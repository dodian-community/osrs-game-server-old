package io.nozemi.runescape.service.redis;

import com.typesafe.config.Config;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.handlers.impl.ConfigHandler;
import io.nozemi.runescape.service.Service;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class RedisService<T> implements Service {

    private static final Logger logger = LogManager.getLogger(RedisService.class);

    private JedisPool jedis;

    private String host = "localhost";
    private String password = null;
    private int port = 6379;
    private int timeout = 1000;

    @Override
    public void setup() {
        ConfigHandler configHandler = GameInitializer.handler(ConfigHandler.class)
                .orElseThrow(() -> new RuntimeException("Failed to find ConfigHandler..."));

        Config config = configHandler.config();

        host = config.getString("redis.host");
        port = config.getInt("redis.port");
        if(config.hasPath("redis.password")) {
            password = config.getString("redis.password");
        }
        timeout = config.getInt("redis.timeout");

        logger.info("Enabling Redis service.");
    }

    @Override
    public boolean start() {
        GenericObjectPoolConfig<T> conf = new GenericObjectPoolConfig<>();
        conf.setMaxTotal(64);
        conf.setMaxIdle(64);

        jedis = new JedisPool(conf, host, port, timeout, password, Protocol.DEFAULT_DATABASE, null);

        try {
            jedis.getResource().connect(); // Test connection
        } catch (Exception e) {
            logger.error("Could not connect to Redis service on {}:{} with timeout {}.", host, port, timeout);
            logger.error("\t" + e);
            return false;
        }

        logger.info("Connected to Redis service on {}:{}.", host, port);
        return true;
    }

    @Override
    public boolean stop() {
        jedis.destroy();
        return true;
    }

    @Override
    public boolean isAlive() {
        try {
            return jedis.getResource().isConnected();
        } catch (JedisConnectionException e) {
            return false;
        }
    }

    public void doOnPool(Consumer<Jedis> todo) {
        Jedis j = jedis.getResource();
        todo.accept(j);
        j.close();
    }

    public Object doOnPoolReturning(Function<Jedis, Object> todo) {
        Jedis j = jedis.getResource();
        Object v = todo.apply(j);
        j.close();
        return v;
    }
}
