package com.nilsr99.timesystem.model;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Administrator extends User {
    private final Map<String, User> employeeDatabase = new HashMap<>(); // Store employee credentials

    public Administrator(String username, String password) {
        super(username, password);
        setRole("Administrator");
        System.out.printf("Administrator %s created with staff number %03d%n", getUsername(), getStaffNumber());
    }

    @Override
    public void displayRole() {
        System.out.println("Role: " + getRole());
    }

     /**
     * Überprüft, ob das Passwort die Mindestanforderungen erfüllt:
     * mindestens 8 Zeichen, mindestens 1 Zahl, 1 Großbuchstabe und 1 Kleinbuchstabe.
     *
     * @param password das zu überprüfende Passwort
     * @return true, wenn das Passwort gültig ist, sonst false
     */
    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    public void addFullTimeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username for Full-Time Employee: ");
        String username = scanner.nextLine();
        if (employeeDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }
        System.out.print("Enter password for Full-Time Employee: ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters long, contain at least one digit, one uppercase letter, and one lowercase letter.");
            return;
        }
        FullTimeEmployee employee = new FullTimeEmployee(username, password);
        employeeDatabase.put(username, employee); // Store the employee's credentials
        System.out.printf("Full-Time Employee %s added with staff number %03d%n", employee.getUsername(), employee.getStaffNumber());
    }

    public void addPartTimeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username for Full-Time Employee: ");
        String username = scanner.nextLine();
        if (employeeDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }
        System.out.print("Enter password for Full-Time Employee: ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters long, contain at least one digit, one uppercase letter, and one lowercase letter.");
            return;
        }
        PartTimeEmployee employee = new PartTimeEmployee(username, password);
        employeeDatabase.put(username, employee); // Store the employee's credentials
        System.out.printf("Part-Time Employee %s added with staff number %03d%n", employee.getUsername(), employee.getStaffNumber());
    }
    
    public void removeEmployee(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username of the employee to remove: ");
        String usernameToRemove = scanner.nextLine();
        if (employeeDatabase.containsKey(usernameToRemove)) {
            employeeDatabase.remove(usernameToRemove);
            System.out.printf("Employee %s removed successfully.%n", usernameToRemove);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayAllEmployees() {
        if (employeeDatabase.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("List of Employees:");
            for (String username : employeeDatabase.keySet()) {
                System.out.println("- " + username);
            }
        }
    }

    public User getEmployee(String username) {
        return employeeDatabase.get(username);
    }

    public Map<String, User> getEmployeeDatabase() {
        return employeeDatabase;
    }
}