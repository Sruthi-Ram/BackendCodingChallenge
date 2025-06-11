package com.hexaware.cricketTeam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "player_id")
    @NotNull(message = "Player ID is required")
    private Long playerId;

    @Column(name = "player_name", nullable = false)
    @NotBlank(message = "Player Name is required")
    private String playerName;

    @Column(name = "jersey_number", nullable = false)
    @Min(value = 1, message = "Jersey number must be greater than 0")
    private int jerseyNumber;

    @Column(name = "role", nullable = false)
    @Pattern(
    	    regexp = "Batsman|Bowler|All Rounder|Wicket Keeper",
    	    message = "Role must be one of: Batsman, Bowler, All Rounder, Wicket Keeper"
    	)
    @NotBlank(message = "Role is required")
    private String role;

    @Column(name = "total_matches")
    @Min(value = 0, message = "Total matches cannot be negative")
    private int totalMatches;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "country_name")
    private String country;

    @Column(name = "description", length = 1000)
    private String description;

    public Player() {
    }

    public Player(@NotNull(message = "Player ID is required") Long playerId, String playerName, int jerseyNumber, String role,
                  int totalMatches, String teamName, String country, String description) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.country = country;
        this.description = description;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}