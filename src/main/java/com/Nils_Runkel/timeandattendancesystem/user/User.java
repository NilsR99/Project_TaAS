package com.Nils_Runkel.timeandattendancesystem.user;

public abstract class User {
    private int staffNumber;
    private String role;
    private String username;
    private String password;

    //Konstruktor
    public User(int staffNumber, String role, String username, String password) {
        this.staffNumber = staffNumber;
        this.role = role;
        this.username = username;
        this.password = password;
    }
    //Getter und Setter
    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
