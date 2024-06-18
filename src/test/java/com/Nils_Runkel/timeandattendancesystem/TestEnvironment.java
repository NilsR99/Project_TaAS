package com.Nils_Runkel.timeandattendancesystem;

import com.Nils_Runkel.timeandattendancesystem.employee.Administrator;
import com.Nils_Runkel.timeandattendancesystem.employee.Employee;
import com.Nils_Runkel.timeandattendancesystem.menu.Adminmenu;
import com.Nils_Runkel.timeandattendancesystem.menu.EmployeeMenu;
import com.Nils_Runkel.timeandattendancesystem.savedata.DataHandler;
import com.Nils_Runkel.timeandattendancesystem.user.User;

import java.util.Hashtable;
import java.util.Scanner;

public class TestEnvironment {
    public static final String DATA_FILE = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Laden der Mitarbeiterdaten
        Hashtable<String, User> loadedEmployees = DataHandler.loadData(DATA_FILE); // erstellen der Hashtable für die Benutzer
        Administrator admin = new Administrator("Admin", "1234");
        loadedEmployees.put(admin.getUsername(), admin); //erstellten Admin in die Hashtable laden
        admin.setEmployees(loadedEmployees);
        //initialisierung eines boolean Wertes
        boolean running = true;
        //Initialisierung des Integers für Beenden des Programms
        int choice = 0;
        //Schleife, die beim Ausloggen zum Login springt
        while (running) {
            //Abfrage nach dem Benutzernamen
            System.out.print("Benutzername: ");
            String username = scanner.nextLine();
            //Abfrage nach dem Passwort
            System.out.print("Passwort: ");
            String password = scanner.nextLine();
            User user = admin.getEmployee(username);
            if (user != null && user.validatePassword(password)) {
                System.out.println("Login erfolgreich!");
                    if (user.getRole().equals("Administrator")) {
                        Adminmenu adminmenu = new Adminmenu(admin);
                        adminmenu.displayMenu(scanner);
                    } else if (user.getRole().equals("Vollzeitmitarbeiter")) {
                        EmployeeMenu employeeMenu = new EmployeeMenu((Employee) user);
                        employeeMenu.displayMenu(scanner);
                    } else if (user.getRole().equals("Teilzeitmitarbeiter")) {
                        EmployeeMenu employeeMenu = new EmployeeMenu((Employee) user);
                        employeeMenu.displayMenu(scanner);
                    } else {
                        System.out.println("Login fehlgeschlagen!");
                    }
                    //Abfrage, ob das Programm beendet werden soll
                    System.out.println("Möchten Sie das Programm beenden?\n1. Programm beenden\n2. Zurück zum Login");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            running = false;
                            break;
                        case 2:
                            running = true;
                            break;
                        default:
                            System.out.println("Keine gültige Eingabe!\nDas Programm wird beendet");
                            running = false;
                            break;
                    }
                    DataHandler.saveData(admin.getEmployees(), DATA_FILE);
            } else {
                System.out.println("Login Fehlgeschlagen");
            }
            scanner.close();
            System.out.println("Programm beendet!");
        }
    }
}