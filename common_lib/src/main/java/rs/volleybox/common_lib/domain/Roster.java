package rs.volleybox.common_lib.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a roster of a team for a specific season.
 * It contains information about the team, roster ID, and season.
 * The roster ID is used to uniquely identify a roster.
 * A roster is associated with a specific team and season.
 * Rosters can be used to manage player engagements for a particular season.
 * Rosters can be compared based on the team and roster ID.
 *
 * The class is Serializable to allow for object serialization.
 *
 * @author Dimitrije
 */
public class Roster implements Serializable {

    /**
     * The sports team associated with the roster.
     */
    private Team team;

    /**
     * The unique identifier for the roster.
     */
    private int rosterId;

    /**
     * The season during which the roster is active.
     */
    private Season season;

    /**
     * Constructs a new Roster with the provided details.
     *
     * @param team The team associated with the roster.
     * @param rosterId The unique ID of the roster.
     * @param season The season to which the roster belongs.
     */
    public Roster(Team team, int rosterId, Season season) {
        this.team = team;
        this.rosterId = rosterId;
        this.season = season;
    }

    /**
     * Constructs a new Roster associated with a team and season.
     *
     * @param team The team associated with the roster.
     * @param season The season to which the roster belongs.
     */
    public Roster(Team team, Season season) {
        this.team = team;
        this.season = season;
    }

    /**
     * Constructs a new empty Roster.
     */
    public Roster() {
    }

    /**
     * Retrieves the team associated with the roster.
     *
     * @return The team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets the team associated with the roster.
     *
     * @param team The team to be set.
     * @throws NullPointerException If the provided team is null.
     */
    public void setTeam(Team team) {
        if(team == null) {
            throw new NullPointerException("Team cannot be null");
        }
        this.team = team;
    }

    /**
     * Retrieves the unique ID of the roster.
     *
     * @return The roster ID.
     */
    public int getRosterId() {
        return rosterId;
    }

    /**
     * Sets the unique ID of the roster.
     *
     * @param rosterId The roster ID to be set.
     */
    public void setRosterId(int rosterId) {
        this.rosterId = rosterId;
    }

    /**
     * Retrieves the season to which the roster belongs.
     *
     * @return The season.
     */
    public Season getSeason() {
        return season;
    }

    /**
     * Sets the season to which the roster belongs.
     *
     * @param season The season to be set.
     * @throws NullPointerException If the provided season is null.
     */
    public void setSeason(Season season) {
        if(season == null) {
            throw new NullPointerException("Season cannot be null");
        }
        this.season = season;
    }

    /**
     * Generates a hash code for the Roster object based on team and roster ID.
     *
     * @return The hash code value for the team and roster ID combination.
     */
    @Override
    public int hashCode() {
        return Objects.hash(team, rosterId);
    }

    /**
     * Checks if the provided object is equal to this Roster.
     * Two Rosters are considered equal if they have the same team and roster ID.
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
        Roster other = (Roster) obj;
        return rosterId == other.rosterId && Objects.equals(team, other.team);
    }
}
