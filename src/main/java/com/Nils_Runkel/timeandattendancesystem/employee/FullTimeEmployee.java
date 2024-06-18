package com.Nils_Runkel.timeandattendancesystem.employee;

import com.Nils_Runkel.timeandattendancesystem.user.User;

import java.time.Duration;
import java.time.LocalDateTime;

public class FullTimeEmployee extends User implements Employee {
    private static final long serialVersionUID = 1L; //Serialisierungs-ID
    private final double weeklyTargetHours = 40; //wöchentliche Soll-Stunden eines Teilzeitmitarbeiters
    private LocalDateTime startOfWork; //Startzeit der Schicht
    private LocalDateTime endOfWork; //Endzeit der Schicht
    //Konstruktor
    public FullTimeEmployee(String username, String password) {
        super("Vollzeitmitarbeiter", username, password);
        System.out.printf("Der Vollzeitmitarbeiter %s mit der Personalnummer: %03d wurde erstellt.\n", username, getStaffNumber());
    }
    public void displayRole() {
        System.out.println("Rolle: Vollzeitmitarbeiter");
    }

    @Override
    public void recordStartOfWork() {
        this.startOfWork = LocalDateTime.now();
        System.out.println("Arbeitsbeginn aufgezeichnet: " + this.startOfWork);
    }

    @Override
    public void recordEndOfWork() {
        this.endOfWork = LocalDateTime.now();
        System.out.println("Arbeitsende aufgezeichenet: " + this.endOfWork);
    }

    @Override
    public double getArbeitsstunden() {
        if (startOfWork != null && endOfWork != null) {
            Duration duration = Duration.between(startOfWork, endOfWork);
            double hoursWorked = duration.toHours();
            System.out.printf("Arbeitsstunden: %.2f Stunden\n", hoursWorked);
            return hoursWorked;
        } else {
            System.out.println("Arbeitsbeginn oder Arbeitsende wurde nicht erfasst!");
            return 0;
        }
    }
}
