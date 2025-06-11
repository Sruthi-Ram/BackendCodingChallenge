package com.hexaware.cricketTeam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.cricketTeam.entity.Player;

import jakarta.transaction.Transactional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	//-> Task by Trainer
	@Modifying
	@Transactional
	 @Query("DELETE FROM Player p WHERE p.playerName = :playerName")
	    int deleteByPlayerNameCustom(String playerName);
}
