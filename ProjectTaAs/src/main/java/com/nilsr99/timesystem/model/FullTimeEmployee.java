package com.nilsr99.timesystem.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FullTimeEmployee extends User implements Employee {
    private LocalDateTime startOfWork;
    private LocalDateTime endOfWork;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:'00'");
    private double weeklyTargetHours = 40.0; // Default weekly target hours

    public FullTimeEmployee(String username, String password) {
        super(username, password);
        setRole("Full-Time Employee");
        System.out.printf("Full-Time Employee %s created with staff number %03d%n", getUsername(), getStaffNumber());
    }

    @Override
    public void displayRole() {
        System.out.println("Role: " + getRole());
    }

    @Override
    public void recordStartofWork() {
        this.startOfWork = LocalDateTime.now();
        System.out.println("Start of work recorded at: " + this.startOfWork.format(formatter));
    }

    @Override
    public void recordEndofWork() {
        this.endOfWork = LocalDateTime.now();
        System.out.println("End of work recorded at: " + this.endOfWork.format(formatter));
    }

    @Override
    public double calculateWorkedHours() {
        if (startOfWork != null && endOfWork != null) {
            Duration duration = Duration.between(startOfWork, endOfWork);
            return duration.toHours() + (duration.toMinutes() % 60) / 60.0; // Convert to decimal hours
        } else {
            System.out.println("Start or end time not recorded.");
            return 0.0;
        }
    }

    public void setStartOfWork(LocalDateTime startOfWork) {
        this.startOfWork = startOfWork;
    }

    public void setEndOfWork(LocalDateTime endOfWork) {
        this.endOfWork = endOfWork;
    }

    public LocalDateTime getStartOfWork() {
        return startOfWork;
    }

    public LocalDateTime getEndOfWork() {
        return endOfWork;
    }
}