package com.Nils_Runkel.timeandattendancesystem.employee;

import com.Nils_Runkel.timeandattendancesystem.user.User;

public class PartTimeEmployee extends User implements Employee {
    private static final long serialVersionUID = 1L; //Serialisierungs-ID
    private final double weeklyTargetHours = 25; //wöchentliche Soll-Stunden eines Teilzeitmitarbeiters

    public PartTimeEmployee(String username, String password) {
        super("Teilzeitmitarbeiter", username, password);
        System.out.printf("Der Teilzeitmitarbeiter %s mit der Personalnummer: %03d wurde erstellt.\n", username, getStaffNumber());
    }
    public void displayRole() {
        System.out.println("Rolle: Teilzeitmitarbeiter");
    }

    @Override
    public void recordStartOfWork() {

    }

    @Override
    public void recordEndOfWork() {

    }

    @Override
    public double getArbeitsstunden() {
        return 0;
    }
}

