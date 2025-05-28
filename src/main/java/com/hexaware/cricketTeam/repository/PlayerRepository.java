package com.hexaware.cricketTeam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.cricketTeam.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	//@Query ("select p from Player p where p.playerName=:name")
	//Player findByName(@Param("name") String name);
}
