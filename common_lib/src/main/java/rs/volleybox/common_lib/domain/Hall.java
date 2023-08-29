package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 * This class represents a hall entity.
 * A hall has an ID, a name, and an address.
 * This class provides methods to manage the hall's information.
 *
 * The name and address attributes must not be null or empty.
 *
 * The equals and hashCode methods are implemented based on the hall ID.
 *
 * The class implements the Serializable interface to support serialization.
 *
 * @author HOME
 */
public class Hall implements Serializable {

    /** The unique ID of the hall. */
    private int hallId;

    /** The name of the hall. */
    private String hallName;

    /** The address of the hall. */
    private String address;

    /**
     * Constructs a new Hall instance with the specified hall ID, name, and address.
     *
     * @param hallId The unique ID of the hall.
     * @param name The name of the hall.
     * @param address The address of the hall.
     */
    public Hall(int hallId, String name, String address) {
        this.hallId = hallId;
        this.hallName = name;
        this.address = address;
    }

    /**
     * Constructs a new Hall instance with the specified name and address.
     *
     * @param name The name of the hall.
     * @param address The address of the hall.
     */
    public Hall(String name, String address) {
        this.hallName = name;
        this.address = address;
    }

    /**
     * Constructs a new empty Hall instance.
     */
    public Hall() {
    }

    /**
     * Returns the unique ID of the hall.
     *
     * @return The unique ID of the hall.
     */
    public int getHallId() {
        return hallId;
    }

    /**
     * Sets the unique ID of the hall.
     *
     * @param hallId The new unique ID for the hall.
     */
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    /**
     * Returns the name of the hall.
     *
     * @return The name of the hall.
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * Sets the name of the hall.
     *
     * @param hallName The new name for the hall.
     * @throws NullPointerException if the provided name is null.
     * @throws IllegalArgumentException if the provided name is empty.
     */
    public void setHallName(String hallName) {
        if (hallName == null) {
            throw new NullPointerException("Hall name cannot be null");
        }
        if (hallName.isEmpty()) {
            throw new IllegalArgumentException("Hall name cannot be empty");
        }
        this.hallName = hallName;
    }

    /**
     * Returns the address of the hall.
     *
     * @return The address of the hall.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the hall.
     *
     * @param address The new address for the hall.
     * @throws NullPointerException if the provided address is null.
     * @throws IllegalArgumentException if the provided address is empty.
     */
    public void setAddress(String address) {
        if (address == null) {
            throw new NullPointerException("Address cannot be null");
        }
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.address = address;
    }

    /**
     * Returns a string representation of the Hall object.
     *
     * @return A string representation of the Hall object.
     */
    @Override
    public String toString() {
        return "Hall{" + "hallId=" + hallId + ", name=" + hallName + ", address=" + address + '}';
    }

    /**
     * Generates a hash code for the Hall object based on the hall ID.
     *
     * @return The hash code for the Hall object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.hallId;
        return hash;
    }

    /**
     * Compares the Hall object with another object for equality.
     *
     * @param obj The object to compare with.
     * @return True if the Hall objects are equal, otherwise false.
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
        final Hall other = (Hall) obj;
        return this.hallId == other.hallId;
    }
}
