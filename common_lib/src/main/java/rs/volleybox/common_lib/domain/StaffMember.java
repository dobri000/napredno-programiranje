/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HOME
 */
public class StaffMember implements Serializable{
    
    private int staffMemberId;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private Country nationality;

    public StaffMember(int staffMemberId, String firstname, String lastname, LocalDate birthdate, Country nationality) {
        this.staffMemberId = staffMemberId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    public StaffMember(String firstname, String lastname, LocalDate birthdate, Country nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
    
    public StaffMember() {
    }

    public int getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(int staffMemberId) {
        this.staffMemberId = staffMemberId;
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
        return "StaffMember{" + "staffMemberId=" + staffMemberId + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", nationality=" + nationality + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.staffMemberId;
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
        final StaffMember other = (StaffMember) obj;
        return this.staffMemberId == other.staffMemberId;
    }
    
    
    
}
