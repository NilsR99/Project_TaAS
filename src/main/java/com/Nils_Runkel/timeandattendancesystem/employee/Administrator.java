package com.Nils_Runkel.timeandattendancesystem.employee;

import com.Nils_Runkel.timeandattendancesystem.user.User;

import java.util.Hashtable;
import java.util.Scanner;

public class Administrator extends User {
    private Hashtable<String, User> employees; //Hashtable zur Speicherung der Daten der Mitarbeiter
    //Konstruktor
    public Administrator(String username, String password) {
        super("Administrator", username, password);
        this.employees = new Hashtable<>();
    }


    @Override
    public void displayRole() {
        System.out.println("Rolle: Administrator");
    }
    public void addFullTimeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie den Benutzernamen des neuen Mitarbeiters ein: ");
        String username = scanner.nextLine(); //speichert die Benutzernameneingabe in der Variable username
        System.out.println("Geben Sie das gewünschte Passwort des neuen Benutzers ein: "); //speichert die Passworteingabe in der Variable password
        String password = scanner.nextLine();
        System.out.println("Geben Sie das gewünschte Passwort des neuen Benutzers erneut ein: "); //speichert die Passworteingabe in der Variable password2
        String password2 = scanner.nextLine();
        if (password.equals(password2)) {
            FullTimeEmployee employee = new FullTimeEmployee(username, password);
            employees.put(employee.getUsername(), employee);
            System.out.println("Mitarbeiter hinzugefügt: " + employee.getUsername());
        } else {
            System.out.println("Die Passwörter stimmen nicht überein!");
        }
    }

    public void listEmployees() {
        System.out.println("Liste der Mitarbeiter:");
        for (String username : employees.keySet()) {
            User employee = employees.get(username);
            System.out.println("Personalnummer: " + employee.getStaffNumber() + ", Name: " + employee.getUsername() + ", Rolle: " + employee.getRole());
        }
    }
}
