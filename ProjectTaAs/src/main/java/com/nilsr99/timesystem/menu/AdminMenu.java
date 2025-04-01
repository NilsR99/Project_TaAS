package com.nilsr99.timesystem.menu;

import com.nilsr99.timesystem.service.UserService;

import java.util.Scanner;

public class AdminMenu implements Menu {
    private final UserService userService;

    public AdminMenu(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Manage Employees (list/remove)");
            System.out.println("4. Logout");
            System.out.print("Select Option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Verarbeitung des Zeilenumbruchs

            switch (choice) {
                case 1:
                    userService.addFullTimeEmployee();
                    break;
                case 2:
                    userService.addPartTimeEmployee();
                    break;
                case 3:
                    userService.manageEmployees();
                    break;
                case 4:
                    System.out.println("Logout successful.");
                    break;
                default:
                    System.out.println("Invalid Selection.");
                    break;
            }
        }
    }
}