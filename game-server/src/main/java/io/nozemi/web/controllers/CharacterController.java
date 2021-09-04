package io.nozemi.web.controllers;

import io.nozemi.runescape.model.World;
import io.nozemi.runescape.orm.repositories.CharactersRepository;
import io.nozemi.runescape.orm.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharactersRepository repository;
    private final World world;

    @Autowired
    public CharacterController(CharactersRepository repository, World world) {
        this.repository = repository;
        this.world = world;
    }

    @GetMapping
    public List<Character> index() {
        List<Character> characters = new ArrayList<>();
         repository.findAll().forEach(character -> {
             if(world.playerByName(character.getUsername()).isPresent()) {
                 characters.add(new Character(world.playerByName(character.getUsername()).get(), true));
             } else {
                 characters.add(character);
             }
         });

         return characters;
    }
}
