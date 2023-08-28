/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 *
 * @author HOME
 */
public class Team implements Serializable{
    private int teamId;
    private String teamName;
    private int founded;
    private Country country;
    private Hall hall;

    

    public Team(int teamId, String name, int founded, Country country, Hall hall) {
        this.teamId = teamId;
        this.teamName = name;
        this.founded = founded;
        this.country = country;
        this.hall = hall;
    }

    public Team(String name, int founded, Country country, Hall hall) {
        this.teamName = name;
        this.founded = founded;
        this.country = country;
        this.hall = hall;
    }
    
    public Team() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
    	if(teamName == null) {
    		throw new NullPointerException("Team name cannot be null");
    	}
    	if(teamName.isEmpty()) {
    		throw new IllegalArgumentException("Team name cannot be empty");
    	}
        this.teamName = teamName;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
    	if(founded < 0) {
    		throw new IllegalArgumentException("Founded cannot be less then zero");
    	}
        this.founded = founded;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
    	if(country == null) {
    		throw new NullPointerException("Country cannot be null");
    	}
        this.country = country;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
    	if(hall == null) {
    		throw new NullPointerException("Hall cannot be null");
    	}
        this.hall = hall;
    }
    
    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", name=" + teamName + ", founded=" + founded + ", country=" + country + ", hall=" + hall + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.teamId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        return this.teamId == other.teamId;
    }
    
    
    
}
