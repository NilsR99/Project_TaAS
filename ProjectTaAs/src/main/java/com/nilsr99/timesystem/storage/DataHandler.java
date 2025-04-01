package com.nilsr99.timesystem.storage;

import com.nilsr99.timesystem.model.Administrator;
import com.nilsr99.timesystem.model.FullTimeEmployee;
import com.nilsr99.timesystem.model.PartTimeEmployee;
import com.nilsr99.timesystem.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataHandler {
    // saves the user data to a CSV file
    public static void saveUsers(Map<String, User> users, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            // CSV-Header
            pw.println("Username,Password,Role,StaffNumber");
            for (User user : users.values()) {
                pw.printf("%s,%s,%s,%d%n",
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole(),
                        user.getStaffNumber()
                );
            }
         } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving users to file: " + e.getMessage());
            }
        }

    // loads the user data from a CSV file
    public static Map<String, User> loadUsers(String filePath) {
        Map<String, User> users = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return users;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    String username = tokens[0];
                    String password = tokens[1];
                    String role = tokens[2];
                    int staffNumber = Integer.parseInt(tokens[3]);
                    User user = null; // Declare the user variable
                    if ("Administrator".equals(role)) {
                        user = new Administrator(username, password);
                    } else if ("Full-Time Employee".equals(role)) {
                        user = new FullTimeEmployee(username, password);
                    } else if ("Part-Time Employee".equals(role)) {
                        user = new PartTimeEmployee(username, password);
                    }
                    if (user != null) {
                        users.put(username, user);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading users from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing staff number: " + e.getMessage());
        }
        return users;
    }
}