package org.kodejava.example.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateDifference {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1995, Month.AUGUST, 17);
        LocalDate now = LocalDate.now();

        // Obtains a period consisting of the number of years, months and days
        // between two dates.
        Period age = Period.between(birthDate, now);
        System.out.printf("You are now %d years, %d months and %d days old.%n",
                age.getYears(), age.getMonths(), age.getDays());

        // Using ChronoUnit to calculate difference in years, months and days
        // between two dates.
        long years = ChronoUnit.YEARS.between(birthDate, now);
        long months = ChronoUnit.MONTHS.between(birthDate, now);
        long days = ChronoUnit.DAYS.between(birthDate, now);

        System.out.println("Diff in years  = " + years);
        System.out.println("Diff in months = " + months);
        System.out.println("Diff in days   = " + days);
    }
}
