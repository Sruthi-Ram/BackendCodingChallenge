package com.hexaware.cricketTeam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketTeam.dto.DisplayDetails;
import com.hexaware.cricketTeam.entity.Player;
import com.hexaware.cricketTeam.exception.PlayerNotFoundException;
import com.hexaware.cricketTeam.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<DisplayDetails> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        List<DisplayDetails> dtos = new ArrayList<>();

        for (Player player : players) {
            dtos.add(new DisplayDetails(
                    player.getPlayerId(),
                    player.getPlayerName(),
                    player.getJerseyNumber(),
                    player.getRole()));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long playerId) {
        Player player = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Validated @RequestBody Player player) {
        Player savedPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") Long playerId, @Valid @RequestBody Player player) {
    	player.setPlayerId(playerId);
    	Player updatedPlayer = playerService.updatePlayer(playerId, player);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }
    
}
