package io.nozemi.web.controllers;

import io.nozemi.runescape.model.World;
import io.nozemi.web.models.WorldInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
@CrossOrigin(origins = "*")
public class WorldController {

    private final World world;

    @Autowired
    public WorldController(World world) {
        this.world = world;
    }

    @GetMapping
    public WorldInfo index() {
        return new WorldInfo(world);
    }
}
