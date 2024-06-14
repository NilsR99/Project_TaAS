package com.Nils_Runkel.timeandattendancesystem;

import com.Nils_Runkel.timeandattendancesystem.employee.Administrator;
import com.Nils_Runkel.timeandattendancesystem.employee.FullTimeEmployee;
import com.Nils_Runkel.timeandattendancesystem.savedate.DataHandler;
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
                admin.listEmployees();
            }
        }
    }
}
