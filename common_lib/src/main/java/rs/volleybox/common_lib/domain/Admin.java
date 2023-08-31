/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents an administrator in the system.
 * An administrator is identified by a username and password, which are used for authentication.
 * This class provides methods to manage the administrator's information.
 *
 * The username and password must not be null or empty.
 *
 * The equals and hashCode methods are implemented based on the username.
 *
 * The class implements the Serializable interface to support serialization.
 *
 * @author Dimitrije
 */
public class Admin implements Serializable {

    /**
     * The username of the administrator.
     */
    private String username;

    /**
     * The password of the administrator.
     */
    private String password;

    /**
     * Creates a new instance of Admin with the given username and password.
     *
     * @param username The username of the administrator.
     * @param password The password of the administrator.
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a new instance of Admin with the given username.
     *
     * @param username The username of the administrator.
     */
    public Admin(String username) {
        this.username = username;
    }

    /**
     * Creates an empty instance of Admin.
     */
    public Admin() {
    }

    /**
     * Retrieves the username of the administrator.
     *
     * @return The username of the administrator.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the administrator.
     *
     * @param username The new username to set.
     * @throws NullPointerException If the provided username is null.
     * @throws IllegalArgumentException If the provided username is empty.
     */
    public void setUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    /**
     * Retrieves the password of the administrator.
     *
     * @return The password of the administrator.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the administrator.
     *
     * @param password The new password to set.
     * @throws NullPointerException If the provided password is null.
     * @throws IllegalArgumentException If the provided password is empty.
     */
    public void setPassword(String password) {
        if (password == null) {
            throw new NullPointerException("Password cannot be null");
        }
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.password = password;
    }

    /**
     * Returns a string representation of the Admin object.
     *
     * @return A string representation of the Admin object.
     */
    @Override
    public String toString() {
        return "Admin{" + "username=" + username + ", password=" + password + '}';
    }

    /**
     * Generates a hash code for the Admin object.
     *
     * @return The hash code value based on the username.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.username);
        return hash;
    }

    /**
     * Checks if the Admin object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal based on username, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Admin other = (Admin) obj;
        return Objects.equals(this.username, other.username);
    }
}
