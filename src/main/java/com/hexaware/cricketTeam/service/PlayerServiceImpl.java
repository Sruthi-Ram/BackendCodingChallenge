package com.hexaware.cricketTeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketTeam.entity.Player;
import com.hexaware.cricketTeam.exception.PlayerNotFoundException;
import com.hexaware.cricketTeam.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long playerId, Player player) {
        Player existingPlayer = getPlayerById(playerId);

        if (player.getPlayerName() != null && !player.getPlayerName().isEmpty()) {
            existingPlayer.setPlayerName(player.getPlayerName());
        }
        if (player.getJerseyNumber() > 0) {  // assuming 0 means not provided
            existingPlayer.setJerseyNumber(player.getJerseyNumber());
        }
        if (player.getRole() != null && !player.getRole().isEmpty()) {
            existingPlayer.setRole(player.getRole());
        }
        if (player.getTotalMatches() >= 0) {  // total matches can be zero
            existingPlayer.setTotalMatches(player.getTotalMatches());
        }
        if (player.getTeamName() != null && !player.getTeamName().isEmpty()) {
            existingPlayer.setTeamName(player.getTeamName());
        }
        if (player.getCountry() != null && !player.getCountry().isEmpty()) {
            existingPlayer.setCountry(player.getCountry());
        }
        if (player.getDescription() != null && !player.getDescription().isEmpty()) {
            existingPlayer.setDescription(player.getDescription());
        }

        return playerRepository.save(existingPlayer);
    }


    @Override
    public void deletePlayer(Long playerId) {
        Player existingPlayer = getPlayerById(playerId);
        playerRepository.delete(existingPlayer);
    }
     // -> Task by Trainer
    @Override
    public void deletePlayerByName(String playerName) {
        int rowsDeleted = playerRepository.deleteByPlayerNameCustom(playerName);
        if (rowsDeleted == 0) {
            throw new PlayerNotFoundException("Player with name '" + playerName + "' not found.");
        }
    }


}
