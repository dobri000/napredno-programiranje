package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 * This class represents a country entity.
 * A country has an ID and a name.
 * This class provides methods to manage the country's information.
 *
 * The name attribute must not be null or empty.
 *
 * The equals and hashCode methods are implemented based on the country ID.
 *
 * The class implements the Serializable interface to support serialization.
 *
 * @author HOME
 */
public class Country implements Serializable {

    /** The unique ID of the country. */
    private int countryId;

    /** The name of the country. */
    private String countryName;

    /**
     * Constructs a new Country instance with the specified country ID and name.
     *
     * @param countryId The unique ID of the country.
     * @param name The name of the country.
     */
    public Country(int countryId, String name) {
        this.countryId = countryId;
        this.countryName = name;
    }

    /**
     * Constructs a new Country instance with the specified name.
     *
     * @param name The name of the country.
     */
    public Country(String name) {
        this.countryName = name;
    }

    /**
     * Constructs a new empty Country instance.
     */
    public Country() {
    }

    /**
     * Returns the unique ID of the country.
     *
     * @return The unique ID of the country.
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * Sets the unique ID of the country.
     *
     * @param countryId The new unique ID for the country.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * Returns the name of the country.
     *
     * @return The name of the country.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the name of the country.
     *
     * @param countryName The new name for the country.
     * @throws NullPointerException if the provided name is null.
     * @throws IllegalArgumentException if the provided name is empty.
     */
    public void setCountryName(String countryName) {
        if (countryName == null) {
            throw new NullPointerException("Country name cannot be null");
        }
        if (countryName.isEmpty()) {
            throw new IllegalArgumentException("Country name cannot be empty");
        }
        this.countryName = countryName;
    }

    /**
     * Returns a string representation of the Country object.
     *
     * @return A string representation of the Country object.
     */
    @Override
    public String toString() {
        return "Country{" + "countryId=" + countryId + ", name=" + countryName + '}';
    }

    /**
     * Generates a hash code for the Country object based on the country ID.
     *
     * @return The hash code for the Country object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.countryId;
        return hash;
    }

    /**
     * Compares the Country object with another object for equality.
     *
     * @param obj The object to compare with.
     * @return True if the Country objects are equal, otherwise false.
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
        final Country other = (Country) obj;
        return this.countryId == other.countryId;
    }
}
