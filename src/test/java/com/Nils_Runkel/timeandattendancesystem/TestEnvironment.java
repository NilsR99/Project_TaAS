package com.Nils_Runkel.timeandattendancesystem;

import com.Nils_Runkel.timeandattendancesystem.employee.Administrator;
import com.Nils_Runkel.timeandattendancesystem.employee.FullTimeEmployee;

import java.util.Scanner;

public class TestEnvironment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administrator admin = new Administrator("Admin", "1234");
        admin.addFullTimeEmployee();
        admin.listEmployees();
    }
}
