package io.nozemi.runescape.content.teleports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.nozemi.runescape.handlers.Handler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TeleportEffectChainHandler implements Handler {

    public static List<MyTeleports> teleports = new ArrayList<>();

    private final ObjectMapper mapper = new ObjectMapper()
            .findAndRegisterModules()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            .enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public void initialize() {
        try {
            loadTeleports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTeleports() throws IOException {
        File file = new File("./data/other/teleports.json");

        teleports = mapper.readValue(file, new TypeReference<>() {});
    }

    public static List<MyTeleports> getTeleports() {
        return teleports;
    }

    public static Optional<MyTeleports> getTeleport(String name) {
        return teleports.stream()
                .filter(teleport -> teleport.name().equalsIgnoreCase(name))
                .findFirst();
    }
}
