package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 * Represents a sports season defined by its start and end years.
 * It contains information about the season ID, start year, and end year.
 * The season ID is used to uniquely identify a season.
 * A season is defined by a range of years, such as "2022/2023".
 * Seasons can be compared based on their IDs.
 *
 * The class is Serializable to allow for object serialization.
 *
 * @author Dimitrije
 */
public class Season implements Serializable {

    /**
     * The unique identifier for the season.
     */
    private int seasonId;

    /**
     * The start year of the season.
     */
    private int startYear;

    /**
     * The end year of the season.
     */
    private int endYear;

    /**
     * Constructs a new Season with the provided details.
     *
     * @param seasonId The unique ID of the season.
     * @param startYear The start year of the season.
     * @param endYear The end year of the season.
     */
    public Season(int seasonId, int startYear, int endYear) {
        this.seasonId = seasonId;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    /**
     * Constructs a new Season with the start and end years.
     *
     * @param startYear The start year of the season.
     * @param endYear The end year of the season.
     */
    public Season(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    /**
     * Constructs a new empty Season.
     */
    public Season() {
    }

    /**
     * Retrieves the unique ID of the season.
     *
     * @return The season ID.
     */
    public int getSeasonId() {
        return seasonId;
    }

    /**
     * Sets the unique ID of the season.
     *
     * @param seasonId The season ID to be set.
     */
    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * Retrieves the start year of the season.
     *
     * @return The start year.
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * Sets the start year of the season.
     *
     * @param startYear The start year to be set.
     * @throws IllegalArgumentException If the provided start year is negative.
     */
    public void setStartYear(int startYear) {
        if(startYear < 0) {
            throw new IllegalArgumentException("Start year cannot be less than zero");
        }
        this.startYear = startYear;
    }

    /**
     * Retrieves the end year of the season.
     *
     * @return The end year.
     */
    public int getEndYear() {
        return endYear;
    }

    /**
     * Sets the end year of the season.
     *
     * @param endYear The end year to be set.
     * @throws IllegalArgumentException If the provided end year is negative.
     */
    public void setEndYear(int endYear) {
        if(endYear < 0) {
            throw new IllegalArgumentException("End year cannot be less than zero");
        }
        this.endYear = endYear;
    }

    /**
     * Generates a formatted string representation of the season (e.g., "2022/2023").
     *
     * @return The formatted string representation of the season.
     */
    @Override
    public String toString() {
        return startYear + "/" + endYear;
    }

    /**
     * Generates a hash code for the Season object based on the season ID.
     *
     * @return The hash code value for the season ID.
     */
    @Override
    public int hashCode() {
        return seasonId;
    }

    /**
     * Checks if the provided object is equal to this Season.
     * Two Seasons are considered equal if they have the same season ID.
     *
     * @param obj The object to compare.
     * @return True if the objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Season other = (Season) obj;
        return seasonId == other.seasonId;
    }
}
