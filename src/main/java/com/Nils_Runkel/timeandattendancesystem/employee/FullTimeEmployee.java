package com.Nils_Runkel.timeandattendancesystem.employee;

import com.Nils_Runkel.timeandattendancesystem.user.User;

public class FullTimeEmployee extends User implements Employee {
    private final double weeklyTargetHours = 40;

    public FullTimeEmployee(String username, String password) {
        super("Vollzeitmitarbeiter", username, password);
        System.out.printf("Der Vollzeitmitarbeiter %s mit der Personalnummer: %03d wurde erstellt.\n", username, getStaffNumber());
    }
    public void displayRole() {
        System.out.println("Rolle: Vollzeitmitarbeiter");
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
