package com.Nils_Runkel.timeandattendancesystem.user;

import java.util.UUID;

/**
 * Represents a user in the system.
 * This class is abstract and cannot be instantiated directly.
 */
public abstract class User {

    private static int nextStaffnumber = 0;
    private final int staffNumber;
    private String role;
    private final String username;
    private final String password;

    /**
     * Constructs a new User.
     *
     * @param role the role of the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String role, String username, String password) {
        this.staffNumber = nextStaffnumber++;
        this.role = role;
        this.username = username;
        this.password = hashPassword(password); // Hash the password for security
    }
    /**
     * Returns the staff number of the user.
     *
     * @return the staff number of the user
     */
    public int getStaffNumber() {
        return staffNumber;
    }

    /**
     * Returns the role of the user.
     *
     * @return the role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the new role of the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user.
     * Password is hashed and not the original plain text.
     *
     * @return the hashed password of the user
     */
    private String getPassword() {
        return password;
    }

    /**
     * Hashes the password for security reasons.
     *
     * @param password the plain text password
     * @return the hashed password
     */
    private String hashPassword(String password) {
        // Implement a hashing algorithm like bcrypt or SHA-256
        // For demonstration, this is a simple placeholder
        return Integer.toHexString(password.hashCode());
    }

    /**
     * Validates the user's password.
     *
     * @param password the plain text password to validate
     * @return true if the password is correct, false otherwise
     */
    public boolean validatePassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    /**
     * Displays the role of the user.
     * Must be implemented by subclasses.
     */
    public abstract void displayRole();
}
