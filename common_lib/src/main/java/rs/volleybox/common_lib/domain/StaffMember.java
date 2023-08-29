package rs.volleybox.common_lib.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a staff member involved in a sports team.
 * It contains information about the staff member's ID, first name, last name,
 * birthdate, and nationality.
 * The staff member ID is used to uniquely identify a staff member.
 *
 * The class is Serializable to allow for object serialization.
 *
 * @author HOME
 */
public class StaffMember implements Serializable{

    /**
     * The unique identifier for the staff member.
     */
    private int staffMemberId;

    /**
     * The first name of the staff member.
     */
    private String firstname;

    /**
     * The last name of the staff member.
     */
    private String lastname;

    /**
     * The birthdate of the staff member.
     */
    private LocalDate birthdate;

    /**
     * The nationality of the staff member.
     */
    private Country nationality;

    /**
     * Constructs a new StaffMember with the provided details.
     *
     * @param staffMemberId The unique ID of the staff member.
     * @param firstname The first name of the staff member.
     * @param lastname The last name of the staff member.
     * @param birthdate The birthdate of the staff member.
     * @param nationality The nationality of the staff member.
     */
    public StaffMember(int staffMemberId, String firstname, String lastname, LocalDate birthdate, Country nationality) {
        this.staffMemberId = staffMemberId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    /**
     * Constructs a new StaffMember with the provided details.
     *
     * @param firstname The first name of the staff member.
     * @param lastname The last name of the staff member.
     * @param birthdate The birthdate of the staff member.
     * @param nationality The nationality of the staff member.
     */
    public StaffMember(String firstname, String lastname, LocalDate birthdate, Country nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    /**
     * Constructs a new empty StaffMember.
     */
    public StaffMember() {
    }

    /**
     * Retrieves the unique ID of the staff member.
     *
     * @return The staff member ID.
     */
    public int getStaffMemberId() {
        return staffMemberId;
    }

    /**
     * Sets the unique ID of the staff member.
     *
     * @param staffMemberId The staff member ID to be set.
     */
    public void setStaffMemberId(int staffMemberId) {
        this.staffMemberId = staffMemberId;
    }

    /**
     * Retrieves the first name of the staff member.
     *
     * @return The first name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the staff member.
     *
     * @param firstname The first name to be set.
     * @throws NullPointerException If the provided first name is null.
     * @throws IllegalArgumentException If the provided first name is empty.
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
     * Retrieves the last name of the staff member.
     *
     * @return The last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the staff member.
     *
     * @param lastname The last name to be set.
     * @throws NullPointerException If the provided last name is null.
     * @throws IllegalArgumentException If the provided last name is empty.
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
     * Retrieves the birthdate of the staff member.
     *
     * @return The birthdate.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the staff member.
     *
     * @param birthdate The birthdate to be set.
     * @throws NullPointerException If the provided birthdate is null.
     */
    public void setBirthdate(LocalDate birthdate) {
        if(birthdate == null) {
            throw new NullPointerException("Birthdate cannot be null");
        }
        this.birthdate = birthdate;
    }

    /**
     * Retrieves the nationality of the staff member.
     *
     * @return The nationality.
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the staff member.
     *
     * @param nationality The nationality to be set.
     * @throws NullPointerException If the provided nationality is null.
     */
    public void setNationality(Country nationality) {
        if(nationality == null) {
            throw new NullPointerException("Nationality cannot be null");
        }
        this.nationality = nationality;
    }

    /**
     * Generates a string representation of the StaffMember object.
     *
     * @return The string representation containing staff member details.
     */
    @Override
    public String toString() {
        return "StaffMember{" + "staffMemberId=" + staffMemberId + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", nationality=" + nationality + '}';
    }

    /**
     * Generates a hash code for the StaffMember object based on the staff member ID.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.staffMemberId;
        return hash;
    }

    /**
     * Compares the StaffMember object with another object for equality.
     * Two staff members are considered equal if they have the same staff member ID.
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
        final StaffMember other = (StaffMember) obj;
        return this.staffMemberId == other.staffMemberId;
    }
}

