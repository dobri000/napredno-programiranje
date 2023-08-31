package rs.volleybox.common_lib.domain;

import rs.volleybox.common_lib.enumeration.StaffMemberPosition;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the engagement of a staff member with a roster in a specific position.
 * This class contains information about the staff member, the roster, and their position.
 *
 * @author Dimitrije
 */
public class StaffMemberEngagement implements Serializable{

    /**
     * The staff member involved in the engagement.
     */
    private StaffMember staffMember;

    /**
     * The roster to which the staff member is engaged.
     */
    private Roster roster;

    /**
     * The position held by the staff member within the roster.
     */
    private StaffMemberPosition position;

    /**
     * Creates a new StaffMemberEngagement object with the specified staff member, roster, and position.
     *
     * @param staffMember The staff member involved in the engagement.
     * @param roster The roster with which the staff member is engaged.
     * @param position The position of the staff member in the roster.
     */
    public StaffMemberEngagement(StaffMember staffMember, Roster roster, StaffMemberPosition position) {
        this.staffMember = staffMember;
        this.roster = roster;
        this.position = position;
    }

    /**
     * Creates an empty StaffMemberEngagement object.
     */
    public StaffMemberEngagement() {
    }

    /**
     * Retrieves the staff member involved in the engagement.
     *
     * @return The staff member.
     */
    public StaffMember getStaffMember() {
        return staffMember;
    }

    /**
     * Sets the staff member involved in the engagement.
     *
     * @param staffMember The staff member to set.
     * @throws NullPointerException If the provided staff member is null.
     */
    public void setStaffMember(StaffMember staffMember) {
        if(staffMember == null) {
            throw new NullPointerException("Staff member cannot be null");
        }
        this.staffMember = staffMember;
    }

    /**
     * Retrieves the roster with which the staff member is engaged.
     *
     * @return The roster.
     */
    public Roster getRoster() {
        return roster;
    }

    /**
     * Sets the roster with which the staff member is engaged.
     *
     * @param roster The roster to set.
     * @throws NullPointerException If the provided roster is null.
     */
    public void setRoster(Roster roster) {
        if(roster == null) {
            throw new NullPointerException("Roster cannot be null");
        }
        this.roster = roster;
    }

    /**
     * Retrieves the position of the staff member in the roster.
     *
     * @return The position.
     */
    public StaffMemberPosition getPosition() {
        return position;
    }

    /**
     * Sets the position of the staff member in the roster.
     *
     * @param position The position to set.
     * @throws NullPointerException If the provided position is null.
     */
    public void setPosition(StaffMemberPosition position) {
        if(position == null) {
            throw new NullPointerException("Position cannot be null");
        }
        this.position = position;
    }

    /**
     * Generates a hash code for the StaffMemberEngagement object based on the staff member and roster.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.staffMember);
        hash = 61 * hash + Objects.hashCode(this.roster);
        return hash;
    }

    /**
     * Compares the StaffMemberEngagement object with another object for equality.
     * Two engagements are considered equal if they have the same staff member and roster.
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
        final StaffMemberEngagement other = (StaffMemberEngagement) obj;
        if (!Objects.equals(this.staffMember, other.staffMember)) {
            return false;
        }
        return Objects.equals(this.roster, other.roster);
    }
}
