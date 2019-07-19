package org.kodejava.example.datetime;

import java.time.*;

public class TimeDifference {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.of(16, 59, 55);
        Duration duration = Duration.between(start, end);

        System.out.printf("Seconds between %s and %s is: %s seconds.%n",
                start, end, duration.getSeconds());

        diffLocalDateTime();
        diffInstant();
    }

    /**
     * Difference between two LocalDateTime objects.
     */
    public static void diffLocalDateTime() {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("GMT+0"));
        Duration duration = Duration.between(dt1, dt2);
        System.out.printf("Duration = %s seconds.%n", duration.getSeconds());
    }

    /**
     * Difference between two Instant objects.
     */
    public static void diffInstant() {
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.EPOCH;
        Duration duration = Duration.between(instant1, instant2);
        System.out.printf("Duration = %s seconds.%n", duration.getSeconds());
    }
}
