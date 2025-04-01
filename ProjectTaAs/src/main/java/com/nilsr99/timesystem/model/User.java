package com.nilsr99.timesystem.model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nextStaffNumber = 0;

    private final int staffNumber;
    private String role;
    private final String username;
    private String password;

    public User(String username, String password) {
        this.staffNumber = nextStaffNumber++;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public abstract void displayRole();

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
