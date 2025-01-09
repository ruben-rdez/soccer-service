package com.soccer.controller;

import com.soccer.entity.Player;
import com.soccer.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soccer/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> players = playerService.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Player player) {
        String message = playerService.save(player);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPetById(@PathVariable Long id) {
        Optional<Player> player = playerService.findById(id);
        return player.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        String message = playerService. updateById(id, updatedPlayer);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String message = playerService.deleteById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/welcome")
    public String greetings() {
        return "Welcome to Soccer Service";
    }

    @GetMapping("/login")
    public String login() {
        return "Logging to Soccer Service";
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logging out from Soccer Service";
    }
}
