package com.nilsr99.timesystem.menu;

import com.nilsr99.timesystem.model.Administrator;
import com.nilsr99.timesystem.model.User;
import com.nilsr99.timesystem.service.UserService;

import com.nilsr99.timesystem.menu.EmployeeMenu;

import java.util.Scanner;

public class LoginMenu implements Menu {
    private final UserService userService;

    public LoginMenu() {
        // Create an instance of Administrator to manage users
        Administrator admin = new Administrator("admin", "Admin1234");
        this.userService = new UserService(admin);
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();

            User user = userService.getUser(username);
            if (user != null && user.validatePassword(password)) {
                System.out.printf("Welcome %s!%n", username);
                if (user.getRole().equals("Administrator")) {
                    new AdminMenu(userService).display();
                } else {
                    new EmployeeMenu(userService, user).display();
                }
                System.out.println("Exit Program? (y/n)");
                String exitChoice = scanner.nextLine();
                if ("y".equalsIgnoreCase(exitChoice)) {
                    running = false;
                }
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Exit Program!");
    }
}