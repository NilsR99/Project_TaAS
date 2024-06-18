package com.Nils_Runkel.timeandattendancesystem.menu;

import com.Nils_Runkel.timeandattendancesystem.employee.Administrator;

import java.util.Scanner;

public class Adminmenu implements Menu{
    private Administrator admin;
    //Konstruktor
    public Adminmenu(Administrator admin) {
        this.admin = admin;
    }
    //Das Display des Menüs für Admins
    public void displayMenu(Scanner scanner) {
        int choice = 0;
        while (choice != 4) {
            System.out.print("1. Mitarbeiter hinzufügen\n2. Mitarbeiter entfernen\n3. Mitarbeiter anzeigen\n4. Ausloggen\n");
            System.out.println("Bitte wählen Sie eine der Optionen aus: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    boolean runningAddEmployee = true;
                    int choice2 = 0;
                    while (choice2 != 3) {
                        System.out.print("1. Vollzeitmitarbeiter hinzufügen\n2. Teilzeitmitarbeiter hinzufügen\n3. Abbrechen\n");
                        System.out.println("\nBitte wählen Sie eine der Optionen aus: ");
                        choice2 = scanner.nextInt();
                        scanner.nextLine();
                        while (runningAddEmployee) {
                            switch (choice2) {
                                case 1:
                                    admin.addFullTimeEmployee();
                                    runningAddEmployee = false;
                                    break;
                                case 2:
                                    admin.addPartTimeEmployee();
                                    runningAddEmployee = false;
                                    break;
                                case 3:
                                    runningAddEmployee = false;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    admin.removeEmployee();
                    break;
                case 3:
                    admin.listEmployees();
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
