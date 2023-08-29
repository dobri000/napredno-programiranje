package rs.volleybox.common_lib.domain;

import rs.volleybox.common_lib.enumeration.PlayerPosition;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an engagement of a player in a specific roster and position.
 * It contains information about the player, roster, position, and jersey number.
 *
 * @author HOME
 */
public class PlayerEngagement implements Serializable{

    /**
     * The player associated with the engagement.
     */
    private Player player;

    /**
     * The roster in which the player is engaged.
     */
    private Roster roster;

    /**
     * The player's position in the team.
     */
    private PlayerPosition position;

    /**
     * The jersey number of the player.
     */
    private int number;

    /**
     * Constructs a new PlayerEngagement with the provided details.
     *
     * @param player The player engaged in the roster.
     * @param roster The roster in which the player is engaged.
     * @param position The position at which the player is engaged.
     * @param number The jersey number assigned to the player in this engagement.
     */
    public PlayerEngagement(Player player, Roster roster, PlayerPosition position, int number) {
        this.player = player;
        this.roster = roster;
        this.position = position;
        this.number = number;
    }

    /**
     * Constructs a new empty PlayerEngagement.
     */
    public PlayerEngagement() {
    }

    /**
     * Retrieves the player engaged in this engagement.
     *
     * @return The engaged player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player engaged in this engagement.
     *
     * @param player The player to be set.
     * @throws NullPointerException If the provided player is null.
     */
    public void setPlayer(Player player) {
        if(player == null) {
            throw new NullPointerException("Player cannot be null");
        }
        this.player = player;
    }

    /**
     * Retrieves the roster in which the player is engaged.
     *
     * @return The roster.
     */
    public Roster getRoster() {
        return roster;
    }

    /**
     * Sets the roster in which the player is engaged.
     *
     * @param roster The roster to be set.
     * @throws NullPointerException If the provided roster is null.
     */
    public void setRoster(Roster roster) {
        if(roster == null) {
            throw new NullPointerException("Roster cannot be null");
        }
        this.roster = roster;
    }

    /**
     * Retrieves the position at which the player is engaged.
     *
     * @return The player's position in the roster.
     */
    public PlayerPosition getPosition() {
        return position;
    }

    /**
     * Sets the position at which the player is engaged.
     *
     * @param position The position to be set.
     * @throws NullPointerException If the provided position is null.
     */
    public void setPosition(PlayerPosition position) {
        if(position == null) {
            throw new NullPointerException("Position cannot be null");
        }
        this.position = position;
    }

    /**
     * Retrieves the jersey number assigned to the player in this engagement.
     *
     * @return The player's jersey number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the jersey number assigned to the player in this engagement.
     *
     * @param number The jersey number to be set.
     * @throws IllegalArgumentException If the provided number is negative.
     */
    public void setNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("Number cannot be less than zero");
        }
        this.number = number;
    }

    /**
     * Generates a hash code for the PlayerEngagement object based on player and roster.
     *
     * @return The hash code value for the player and roster combination.
     */
    @Override
    public int hashCode() {
        return Objects.hash(player, roster);
    }

    /**
     * Checks if the provided object is equal to this PlayerEngagement.
     * Two PlayerEngagements are considered equal if they have the same player and roster.
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
        PlayerEngagement other = (PlayerEngagement) obj;
        return Objects.equals(player, other.player) && Objects.equals(roster, other.roster);
    }
}
