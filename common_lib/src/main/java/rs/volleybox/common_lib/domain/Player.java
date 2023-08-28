/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import rs.volleybox.common_lib.enumeration.Hand;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HOME
 */
public class Player implements Serializable{
    
    private int playerId;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private int height;
    private int weight;
    private int spike;
    private int block;
    private Hand dominantHand;
    private Country nationality;

    public Player(int playerId, String firstname, String lastname, LocalDate birthdate, int height, int weight, int spike, int block, Hand dominantHand, Country nationality) {
        this.playerId = playerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.spike = spike;
        this.block = block;
        this.dominantHand = dominantHand;
        this.nationality = nationality;
    }

    public Player(String firstname, String lastname, LocalDate birthdate, int height, int weight, int spike, int block, Hand dominantHand, Country nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.spike = spike;
        this.block = block;
        this.dominantHand = dominantHand;
        this.nationality = nationality;
    }
    
    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
    	if(firstname == null) {
    		throw new NullPointerException("Firstname cannot be null");
    	}
    	if(firstname.isEmpty()) {
    		throw new IllegalArgumentException("Firstname cannot be empty");
    	}
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
    	if(lastname == null) {
    		throw new NullPointerException("Lastname cannot be null");
    	}
    	if(lastname.isEmpty()) {
    		throw new IllegalArgumentException("Lastname cannot be empty");
    	}
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
    	if(birthdate == null) {
    		throw new NullPointerException("Birthdate cannot be null");
    	}
        this.birthdate = birthdate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
    	if(height < 0) {
    		throw new IllegalArgumentException("Height cannot be less then zero");
    	}
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
    	if(weight < 0) {
    		throw new IllegalArgumentException("Weight cannot be less then zero");
    	}
        this.weight = weight;
    }

    public int getSpike() {
        return spike;
    }

    public void setSpike(int spike) {
    	if(spike < 0) {
    		throw new IllegalArgumentException("Spike cannot be less then zero");
    	}
        this.spike = spike;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
    	if(block < 0) {
    		throw new IllegalArgumentException("Block cannot be less then zero");
    	}
        this.block = block;
    }

    public Hand getDominantHand() {
        return dominantHand;
    }

    public void setDominantHand(Hand dominantHand) {
    	if(dominantHand == null) {
    		throw new NullPointerException("Dominant hand cannot be null");
    	}
        this.dominantHand = dominantHand;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
    	if(nationality == null) {
    		throw new NullPointerException("Nationality cannot be null");
    	}
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Player{" + "playerId=" + playerId + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", height=" + height + ", weight=" + weight + ", spike=" + spike + ", block=" + block + ", dominantHand=" + dominantHand + ", nationality=" + nationality + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.playerId;
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
        final Player other = (Player) obj;
        return this.playerId == other.playerId;
    }
    
    
    
}
