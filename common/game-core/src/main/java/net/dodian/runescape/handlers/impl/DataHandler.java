package net.dodian.runescape.handlers.impl;

import com.typesafe.config.Config;
import net.dodian.runescape.handlers.Handler;
import net.dodian.runescape.util.HuffmanCodec;
import nl.bartpelle.dawnguard.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataHandler implements Handler {

    private ConfigHandler configHandler;

    private DataStore dataStore;
    private HuffmanCodec huffman;

    @Autowired
    public DataHandler(ConfigHandler configHandler) {
        // TODO: let's clean up this
        this.configHandler = null;//GameInitializer.handler(ConfigHandler.class).orElse(null);
        if(this.configHandler == null) {
            this.configHandler = configHandler;
            this.configHandler.initialize();
        }
    }

    @Override
    public void initialize() {
        Config config = configHandler.config();
        this.dataStore = new DataStore(config.getString("server.filestore"));
        this.huffman = new HuffmanCodec(this.dataStore);
    }

    public DataStore dataStore() {
        return dataStore;
    }

    public HuffmanCodec huffman() {
        return this.huffman;
    }
}
