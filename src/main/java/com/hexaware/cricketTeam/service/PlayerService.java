package com.hexaware.cricketTeam.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hexaware.cricketTeam.entity.Player;

public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayerById(Long playerId);

    Player createPlayer(Player player);

    Player updatePlayer(Long playerId, Player player);

    void deletePlayer(Long playerId);
    
  
}
