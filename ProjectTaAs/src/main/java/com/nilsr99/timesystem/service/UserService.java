package com.nilsr99.timesystem.service;

import com.nilsr99.timesystem.model.Administrator;
import com.nilsr99.timesystem.model.FullTimeEmployee;
import com.nilsr99.timesystem.model.PartTimeEmployee;
import com.nilsr99.timesystem.model.User;
import com.nilsr99.timesystem.storage.DataHandler;

import java.util.Map;
import java.util.Scanner;

public class UserService {
    private final Administrator admin;
    private final Scanner scanner;
    private final String CSV_FILE = "employees.csv";

public UserService (Administrator admin) {
    this.admin = admin;
    this.scanner = new Scanner(System.in);
    //Load existing users from the data handler
    Map <String, User> loaded = DataHandler.loadUsers(CSV_FILE);
    loaded.forEach((key, user) -> admin.getEmployeeDatabase().put(key, user));
    //Ensure administrator, if not available
    if (admin.getEmployeeDatabase().get(admin.getUsername()) == null) {
        admin.getEmployeeDatabase().put(admin.getUsername(), admin);
    }
    }

    /**
     * Validates if the given password meets the required criteria.
     * @param password The password to validate.
     * @return true if the password is valid, false otherwise.
     */
    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasUppercase && hasLowercase && hasDigit) {
                return true;
            }
        }
        return false;
    }

public User getUser(String username) {
    return admin.getEmployeeDatabase().get(username);
}

public void addFullTimeEmployee() {
    System.out.print("Enter username for Full-Time Employee: ");
    String username = scanner.nextLine();
    if (admin.getEmployeeDatabase().containsKey(username)) {
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
    admin.getEmployeeDatabase().put(username, employee); // Store the employee's credentials
    DataHandler.saveUsers(admin.getEmployeeDatabase(), CSV_FILE); // Save to file
    System.out.printf("Full-Time Employee %s added with staff number %03d%n", employee.getUsername(), employee.getStaffNumber());
}

public void addPartTimeEmployee() {
    System.out.print("Enter username for Part-Time Employee: ");
    String username = scanner.nextLine();
    if (admin.getEmployeeDatabase().containsKey(username)) {
        System.out.println("Username already exists. Please choose a different username.");
        return;
    }
    System.out.print("Enter password for Part-Time Employee: ");
    String password = scanner.nextLine();
    if (!isValidPassword(password)) {
        System.out.println("Password must be at least 8 characters long, contain at least one digit, one uppercase letter, and one lowercase letter.");
        return;
    }
    PartTimeEmployee employee = new PartTimeEmployee(username, password);
    admin.getEmployeeDatabase().put(username, employee); // Store the employee's credentials
    DataHandler.saveUsers(admin.getEmployeeDatabase(), CSV_FILE); // Save to file
    System.out.printf("Part-Time Employee %s added with staff number %03d%n", employee.getUsername(), employee.getStaffNumber());
}

public void manageEmployees() {
    System.out.println("\n--- Employee Administration ---");
    admin.displayAllEmployees();
    System.out.print("Do you want to remove an employee? (y/n): ");
    String choice = scanner.nextLine();
    if ("y".equalsIgnoreCase(choice)) {
        System.out.print("Enter username of the employee to remove: ");
        String username = scanner.nextLine();
        if (admin.getEmployeeDatabase().containsKey(username)) {
            admin.getEmployeeDatabase().remove(username);
            DataHandler.saveUsers(admin.getEmployeeDatabase(), CSV_FILE); // Save to file
            System.out.printf("Employee %s removed successfully.%n", username);
        } else {
            System.out.println("Employee not found.");
        }
        }
    }
}