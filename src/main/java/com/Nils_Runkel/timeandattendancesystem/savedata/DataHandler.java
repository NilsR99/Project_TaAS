package com.Nils_Runkel.timeandattendancesystem.savedata;

import com.Nils_Runkel.timeandattendancesystem.user.User;

import java.io.*;
import java.util.Hashtable;

public class DataHandler {
    public static void saveData(Hashtable<String, User> employees, String employeeData) {
        try (FileOutputStream fos = new FileOutputStream(employeeData);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Hashtable<String, User> loadData(String employeeData) {
        Hashtable<String, User> employees = new Hashtable<>();
        try (FileInputStream fis = new FileInputStream(employeeData);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            employees = (Hashtable<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
