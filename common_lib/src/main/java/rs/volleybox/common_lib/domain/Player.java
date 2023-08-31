/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import rs.volleybox.common_lib.enumeration.Hand;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represents a player entity.
 * A player has various attributes such as ID, first name, last name, birthdate, height, weight,
 * spike reach, block reach, dominant hand, and nationality.
 * This class provides methods to manage the player's information.
 *
 * The first name, last name, birthdate, height, weight, spike reach, block reach, dominant hand,
 * and nationality attributes must not be null or empty where applicable.
 *
 * The equals and hashCode methods are implemented based on the player ID.
 *
 * The class implements the Serializable interface to support serialization.
 *
 * @author Dimitrije
 */
public class Player implements Serializable{

    /** The unique ID of the player. */
    private int playerId;

    /** The first name of the player. */
    private String firstname;

    /** The last name of the player. */
    private String lastname;

    /** The birthdate of the player. */
    private LocalDate birthdate;

    /** The height of the player in centimeters. */
    private int height;

    /** The weight of the player in kilograms. */
    private int weight;

    /** The spike reach of the player in centimeters. */
    private int spike;

    /** The block reach of the player in centimeters. */
    private int block;

    /** The dominant hand of the player. */
    private Hand dominantHand;

    /** The nationality of the player. */
    private Country nationality;

    /**
     * Constructs a new Player instance with the specified attributes.
     *
     * @param playerId The unique ID of the player.
     * @param firstname The first name of the player.
     * @param lastname The last name of the player.
     * @param birthdate The birthdate of the player.
     * @param height The height of the player.
     * @param weight The weight of the player.
     * @param spike The spike reach of the player.
     * @param block The block reach of the player.
     * @param dominantHand The dominant hand of the player.
     * @param nationality The nationality of the player.
     */
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

    /**
     * Constructs a new Player instance with the specified attributes.
     *
     * @param firstname The first name of the player.
     * @param lastname The last name of the player.
     * @param birthdate The birthdate of the player.
     * @param height The height of the player.
     * @param weight The weight of the player.
     * @param spike The spike reach of the player.
     * @param block The block reach of the player.
     * @param dominantHand The dominant hand of the player.
     * @param nationality The nationality of the player.
     */
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

    /**
     * Constructs a new empty Player instance.
     */
    public Player() {
    }

    /**
     * Returns the unique ID of the player.
     *
     * @return The unique ID of the player.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets the unique ID of the player.
     *
     * @param playerId The new unique ID for the player.
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Returns the first name of the player.
     *
     * @return The first name of the player.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the player.
     *
     * @param firstname The new first name for the player.
     * @throws NullPointerException if the provided first name is null.
     * @throws IllegalArgumentException if the provided first name is empty.
     */
    public void setFirstname(String firstname) {
    	if(firstname == null) {
    		throw new NullPointerException("Firstname cannot be null");
    	}
    	if(firstname.isEmpty()) {
    		throw new IllegalArgumentException("Firstname cannot be empty");
    	}
        this.firstname = firstname;
    }

    /**
     * Returns the last name of the player.
     *
     * @return The last name of the player.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the player.
     *
     * @param lastname The new last name for the player.
     * @throws NullPointerException if the provided last name is null.
     * @throws IllegalArgumentException if the provided last name is empty.
     */
    public void setLastname(String lastname) {
    	if(lastname == null) {
    		throw new NullPointerException("Lastname cannot be null");
    	}
    	if(lastname.isEmpty()) {
    		throw new IllegalArgumentException("Lastname cannot be empty");
    	}
        this.lastname = lastname;
    }

    /**
     * Returns the birthdate of the player.
     *
     * @return The birthdate of the player.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the player.
     *
     * @param birthdate The new birthdate for the player.
     * @throws NullPointerException if the provided birthdate is null.
     */
    public void setBirthdate(LocalDate birthdate) {
    	if(birthdate == null) {
    		throw new NullPointerException("Birthdate cannot be null");
    	}
        this.birthdate = birthdate;
    }

    /**
     * Returns the height of the player in centimeters.
     *
     * @return The height of the player.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the player in centimeters.
     *
     * @param height The new height for the player.
     * @throws IllegalArgumentException if the provided height is less than zero.
     */
    public void setHeight(int height) {
    	if(height < 0) {
    		throw new IllegalArgumentException("Height cannot be less then zero");
    	}
        this.height = height;
    }

    /**
     * Returns the weight of the player in kilograms.
     *
     * @return The weight of the player.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the player in kilograms.
     *
     * @param weight The new weight for the player.
     * @throws IllegalArgumentException if the provided weight is less than zero.
     */
    public void setWeight(int weight) {
    	if(weight < 0) {
    		throw new IllegalArgumentException("Weight cannot be less then zero");
    	}
        this.weight = weight;
    }

    /**
     * Returns the spike reach of the player in centimeters.
     *
     * @return The spike reach of the player.
     */
    public int getSpike() {
        return spike;
    }

    /**
     * Sets the spike reach of the player in centimeters.
     *
     * @param spike The new spike reach for the player.
     * @throws IllegalArgumentException if the provided spike reach is less than zero.
     */
    public void setSpike(int spike) {
    	if(spike < 0) {
    		throw new IllegalArgumentException("Spike cannot be less then zero");
    	}
        this.spike = spike;
    }

    /**
     * Returns the block reach of the player in centimeters.
     *
     * @return The block reach of the player.
     */
    public int getBlock() {
        return block;
    }

    /**
     * Sets the block reach of the player in centimeters.
     *
     * @param block The new block reach for the player.
     * @throws IllegalArgumentException if the provided block reach is less than zero.
     */
    public void setBlock(int block) {
    	if(block < 0) {
    		throw new IllegalArgumentException("Block cannot be less then zero");
    	}
        this.block = block;
    }

    /**
     * Returns the dominant hand of the player.
     *
     * @return The dominant hand of the player.
     */
    public Hand getDominantHand() {
        return dominantHand;
    }

    /**
     * Sets the dominant hand of the player.
     *
     * @param dominantHand The new dominant hand for the player.
     * @throws NullPointerException if the provided dominant hand is null.
     */
    public void setDominantHand(Hand dominantHand) {
    	if(dominantHand == null) {
    		throw new NullPointerException("Dominant hand cannot be null");
    	}
        this.dominantHand = dominantHand;
    }

    /**
     * Returns the nationality of the player.
     *
     * @return The nationality of the player.
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the player.
     *
     * @param nationality The new nationality for the player.
     * @throws NullPointerException if the provided nationality is null.
     */
    public void setNationality(Country nationality) {
    	if(nationality == null) {
    		throw new NullPointerException("Nationality cannot be null");
    	}
        this.nationality = nationality;
    }

    /**
     * Returns a string representation of the Player object.
     *
     * @return A string containing the player's information.
     */
    @Override
    public String toString() {
        return "Player{" + "playerId=" + playerId + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", height=" + height + ", weight=" + weight + ", spike=" + spike + ", block=" + block + ", dominantHand=" + dominantHand + ", nationality=" + nationality + '}';
    }

    /**
     * Generates a hash code for the Player object.
     *
     * @return The hash code value for the player based on playerId.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.playerId;
        return hash;
    }

    /**
     * Checks if the provided object is equal to this Player.
     *
     * @param obj The object to compare.
     * @return True if the objects are equal (have the same playerId), otherwise false.
     */
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
