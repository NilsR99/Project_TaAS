package com.nilsr99.timesystem.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class FullTimeEmployeeTest {

    @Test
    void testOneHourWorkingHours() {
        // Erzeugen eines Test-Mitarbeiters
        FullTimeEmployee employee = new FullTimeEmployee("testUser", "Test1234");

        // Simuliere einen Startzeitpunkt (z. B. 09:00)
        LocalDateTime start = LocalDateTime.of(2025, 3, 29, 9, 0, 0);
        // Simuliere ein Endzeitpunkt genau 1 Stunde später (10:00)
        LocalDateTime end = start.plusHours(1);
        
        // Setze die Zeiten manuell (dafür wurden Setter in FullTimeEmployee implementiert)
        employee.setStartOfWork(start);
        employee.setEndOfWork(end);
        
        double workedHours = employee.calculateWorkedHours();
        
        // Klassische Assertion: Prüfen, ob die Arbeitszeit exakt 1.0 Stunden beträgt
        assertEquals(1.0, workedHours, 0.001, "Working hours should be exactly one hour.");
        
        // Deklarative Assertion mit Hamcrest-Matcher:
        assertThat("Working hours must equal 1.0", workedHours, is(closeTo(1.0, 0.001)));
    }
}
