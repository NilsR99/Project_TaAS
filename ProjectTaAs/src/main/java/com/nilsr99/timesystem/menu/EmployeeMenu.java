package com.nilsr99.timesystem.menu;

import com.nilsr99.timesystem.model.Employee;
import com.nilsr99.timesystem.model.User;
import com.nilsr99.timesystem.service.UserService;

import java.util.Scanner;

public class EmployeeMenu implements Menu {
    private final UserService userService;
    private final User user;

    public EmployeeMenu(UserService userService, User user) {
        this.userService = userService;
        this.user = user;
    }
    
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. Show Work Hours");
            System.out.println("4. Logout");
            System.out.print("Select Option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Verarbeitung des Zeilenumbruchs

            if (user instanceof Employee) {
                Employee employee = (Employee) user;
                switch (choice) {
                    case 1:
                        employee.recordStartofWork();
                        break;
                    case 2:
                        employee.recordEndofWork();
                        break;
                    case 3:
                        Double workedhours = employee.calculateWorkedHours();
                        System.out.printf("Worked hours: %.2f hours%n", workedhours);
                        break;
                    case 4:
                        System.out.println("Logout successful.");
                        break;
                    default:
                        System.out.println("Invalid Selection.");
                        break;
                }
            } else {
                System.out.println("You are not an employee. Access denied.");
                choice = 4; // Exit the menu if not an employee
            }
        }
    }
}