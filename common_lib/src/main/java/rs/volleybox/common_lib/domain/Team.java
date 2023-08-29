package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 * Represents a volleyball team with its attributes such as team name, foundation year, country, and home hall.
 * This class provides methods to access and modify team information.
 *
 * @author HOME
 */
public class Team implements Serializable{
    /**
     * The unique identifier for the team.
     */
    private int teamId;

    /**
     * The name of the team.
     */
    private String teamName;

    /**
     * The year the team was founded.
     */
    private int founded;

    /**
     * The country where the team is based.
     */
    private Country country;

    /**
     * The home hall where the team plays its matches.
     */
    private Hall hall;

    /**
     * Creates a new Team object with the specified attributes.
     *
     * @param teamId The unique identifier for the team.
     * @param name The name of the team.
     * @param founded The year the team was founded.
     * @param country The country the team belongs to.
     * @param hall The home hall of the team.
     */
    public Team(int teamId, String name, int founded, Country country, Hall hall) {
        this.teamId = teamId;
        this.teamName = name;
        this.founded = founded;
        this.country = country;
        this.hall = hall;
    }

    /**
     * Creates a new Team object with the specified attributes.
     *
     * @param name The name of the team.
     * @param founded The year the team was founded.
     * @param country The country the team belongs to.
     * @param hall The home hall of the team.
     */
    public Team(String name, int founded, Country country, Hall hall) {
        this.teamName = name;
        this.founded = founded;
        this.country = country;
        this.hall = hall;
    }

    /**
     * Creates an empty Team object.
     */
    public Team() {
    }

    /**
     * Retrieves the unique identifier for the team.
     *
     * @return The team's identifier.
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets the unique identifier for the team.
     *
     * @param teamId The identifier to set.
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Retrieves the name of the team.
     *
     * @return The team's name.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the team.
     *
     * @param teamName The name to set.
     * @throws NullPointerException If the provided team name is null.
     * @throws IllegalArgumentException If the provided team name is empty.
     */
    public void setTeamName(String teamName) {
        if(teamName == null) {
            throw new NullPointerException("Team name cannot be null");
        }
        if(teamName.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        this.teamName = teamName;
    }

    /**
     * Retrieves the year the team was founded.
     *
     * @return The founding year.
     */
    public int getFounded() {
        return founded;
    }

    /**
     * Sets the year the team was founded.
     *
     * @param founded The founding year to set.
     * @throws IllegalArgumentException If the provided founding year is less than zero.
     */
    public void setFounded(int founded) {
        if(founded < 0) {
            throw new IllegalArgumentException("Founded year cannot be less than zero");
        }
        this.founded = founded;
    }

    /**
     * Retrieves the country the team belongs to.
     *
     * @return The team's country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets the country the team belongs to.
     *
     * @param country The country to set.
     * @throws NullPointerException If the provided country is null.
     */
    public void setCountry(Country country) {
        if(country == null) {
            throw new NullPointerException("Country cannot be null");
        }
        this.country = country;
    }

    /**
     * Retrieves the home hall of the team.
     *
     * @return The team's home hall.
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * Sets the home hall of the team.
     *
     * @param hall The home hall to set.
     * @throws NullPointerException If the provided hall is null.
     */
    public void setHall(Hall hall) {
        if(hall == null) {
            throw new NullPointerException("Hall cannot be null");
        }
        this.hall = hall;
    }

    /**
     * Generates a string representation of the Team object.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", name=" + teamName + ", founded=" + founded + ", country=" + country + ", hall=" + hall + '}';
    }

    /**
     * Generates a hash code for the Team object based on the team's identifier.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.teamId;
        return hash;
    }

    /**
     * Compares the Team object with another object for equality.
     * Two teams are considered equal if they have the same team identifier.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
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
        final Team other = (Team) obj;
        return this.teamId == other.teamId;
    }
}
