package com.Nils_Runkel.timeandattendancesystem.user;

import java.io.Serializable;

/**
 * Represents a user in the system.
 * This class is abstract and cannot be instantiated directly.
 */
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L; //Serialisierungs-ID
    private static int nextStaffnumber = 0;
    private final int staffNumber;
    private String role;
    private final String username;
    private final String password;


    public User(String role, String username, String password) {
        this.staffNumber = nextStaffnumber++;
        this.role = role;
        this.username = username;
        this.password = hashPassword(password); // Hash the password for security
    }

    public int getStaffNumber() {
        return staffNumber;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }


    private String getPassword() {
        return password;
    }
    private String hashPassword(String password) {
        return Integer.toHexString(password.hashCode()); //Platzhalter für Passwortverschlüsselung
    }
    public boolean validatePassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    public abstract void displayRole();
}
