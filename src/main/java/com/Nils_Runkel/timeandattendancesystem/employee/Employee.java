package com.Nils_Runkel.timeandattendancesystem.employee;
/**
 * The Employee interface defines the common behavior that all types of employees
 * (e.g., full-time, part-time) must implement in the time tracking system.
 */
public interface Employee {

    /**
     * Records the start time of the work shift for the employee.
     * This method should be called when an employee begins their work shift.
     */
    void recordStartOfWork();

    /**
     * Records the end time of the work shift for the employee.
     * This method should be called when an employee finishes their work shift.
     */
    void recordEndOfWork();

    /**
     * Calculates and returns the total number of hours worked by the employee.
     * This method should compute the total hours based on the recorded start and end times.
     *
     * @return the total number of hours worked
     */
    double getArbeitsstunden();
}
