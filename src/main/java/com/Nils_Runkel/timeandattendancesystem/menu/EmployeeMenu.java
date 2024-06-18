package com.Nils_Runkel.timeandattendancesystem.menu;

import com.Nils_Runkel.timeandattendancesystem.employee.Employee;

import java.util.Scanner;

public class EmployeeMenu implements Menu {
    private Employee employee;
    //Konstruktor
    public EmployeeMenu(Employee employee) {
        this.employee = employee;
    }
    @Override
    public void displayMenu(Scanner scanner) {
        int choice = 0;
        while (choice != 4) {
            System.out.print("1. Einchecken\n2. Auschecken\n3. Arbeitsstunden anzeigen\n4. Ausloggen\n");
            System.out.println("Bitte wählen Sie eine der Optionen aus: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    employee.recordStartOfWork();
                    break;
                case 2:
                    employee.recordEndOfWork();
                    break;
                case 3:
                    employee.getArbeitsstunden();
                    break;
                case 4:
                    System.out.println("ausgeloggt");
                    break;
                default:
                    System.out.println("Das ist keine gültige Option!");
                    break;
            }
        }
    }
}
