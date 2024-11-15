package implementation_java;

import implementation_java.booking.Booking;
import implementation_java.lessons.Lesson;
import implementation_java.locations.Location;
import implementation_java.locations.Space;
import implementation_java.offerings.Mode;
import implementation_java.offerings.Offering;
import implementation_java.scheduling.Schedule;
import implementation_java.scheduling.TimeSlot;
import implementation_java.users.Client;
import implementation_java.users.Guardian;
import implementation_java.users.Instructor;
import implementation_java.locations.City;
import implementation_java.lessons.Specialization;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Create schedules
            System.out.println("""
                    \u001B[34m
                    Create judoSchedule 
                    from 2024-09-01 to 2024-11-30
                    Sunday 12:00-13:00
                    Sunday 13:00-14:00
                    Sunday 14:00-14:30
                    Sunday 14:30-15:00
                    \u001B[0m""");
            Schedule judoSchedule = new Schedule(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 11, 30));
            judoSchedule.addTimeSlot(new TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(12, 0), LocalTime.of(13, 0)));
            judoSchedule.addTimeSlot(new TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(13, 0), LocalTime.of(14, 0)));
            judoSchedule.addTimeSlot(new TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(14, 0), LocalTime.of(14, 30)));
            judoSchedule.addTimeSlot(new TimeSlot(DayOfWeek.SUNDAY, LocalTime.of(14, 30), LocalTime.of(15, 0)));

            System.out.println("""
                    \u001B[34m
                    Create judoOfferings
                    Lesson: JudoGroup1, Schedule: judoSchedule, Space: Gym, Mode: GROUP
                    Lesson: JudoGroup2, Schedule: judoSchedule, Space: Gym, Mode: GROUP
                    Lesson: JudoPrivate1, Schedule: judoSchedule, Space: Gym, Mode: PRIVATE
                    Lesson: JudoPrivate2, Schedule: judoSchedule, Space: Gym, Mode: PRIVATE
                    \u001B[0m""");
            // Create offerings
            Offering judoGroupOffering1 = new Offering(new Lesson("JudoGroup1"), judoSchedule, new Space("Gym", "Main Building", new Location("Main Building", new City("Montreal", "Quebec"))), Mode.GROUP);
            Offering judoGroupOffering2 = new Offering(new Lesson("JudoGroup2"), judoSchedule, new Space("Gym", "Main Building", new Location("Main Building", new City("Montreal", "Quebec"))), Mode.GROUP);
            Offering judoPrivateOffering1 = new Offering(new Lesson("JudoPrivate1"), judoSchedule, new Space("Gym", "Main Building", new Location("Main Building", new City("Montreal", "Quebec"))), Mode.PRIVATE);
            Offering judoPrivateOffering2 = new Offering(new Lesson("JudoPrivate2"), judoSchedule, new Space("Gym", "Main Building", new Location("Main Building", new City("Montreal", "Quebec"))), Mode.PRIVATE);

            System.out.println("""
                    \u001B[34m
                    Create an instructor
                    Username: grace123, Password: password, Name: Grace, Phone: 514-123-4567
                    Specialization: Swimming, Lesson: Swimming
                    Availability: Montreal, Laval
                    \u001B[0m""");
            // Create an instructor
            Instructor grace = new Instructor("grace123", "password", "Grace", "514-123-4567");
            grace.addSpecialization(new Specialization("Swimming", new Lesson("Swimming")));
            grace.updateAvailability(Arrays.asList(new City("Montreal", "Quebec"), new City("Laval", "Quebec")));

            System.out.println("""
                    \u001B[34m
                    Grace selects offerings
                    JudoGroup1, JudoGroup2, JudoPrivate1, JudoPrivate2
                    \u001B[0m""");
            // Instructor selects offerings
            grace.selectOffering(judoGroupOffering1);
            grace.selectOffering(judoGroupOffering2);
            grace.selectOffering(judoPrivateOffering1);
            grace.selectOffering(judoPrivateOffering2);

            System.out.println("""
                    \u001B[34m
                    Guardian James Russo, Phone: 514-987-6543
                    \u001B[0m""");
            // Create a guardian
            Guardian james = new Guardian("James Russo", "514-987-6543");

            System.out.println("""
                    \u001B[34m
                    Client Lisa Russo, Age: 14, Phone: 514-555-1234, Guardian: James Russo
                    \u001B[0m""");
            // Create a client
            Client lisa = new Client("Lisa Russo", 14, "514-555-1234", james);

            System.out.println("""
                    \u001B[34m
                    Client Paul Alfred, Age: 12, Phone: 436-895-0000, No guardian
                    \u001B[0m""");
            // Create a client with no guardian
            Client paul = new Client("Paul Alfred", 12, "436-895-0000", null);

            // Client makes a booking
            System.out.println("\u001B[34mClient Lisa makes a booking\u001B[0m");
            Booking booking1 = lisa.makeBooking(judoGroupOffering1);
            System.out.println("Booking 1 ID: " + booking1.getBookingID() + ", Status: " + booking1.getStatus() + " - Booking successful");
            System.out.println();

            // Offering is no longer available
            try {
                System.out.println("\u001B[34mOffering is no longer available\u001B[0m");
                Booking booking = paul.makeBooking(judoGroupOffering1);
                System.out.println("Booking 1 ID: " + booking.getBookingID() + ", Status: " + booking.getStatus() + " - Booking successful");
            } catch (Exception e) {
                System.out.println("Failed to make booking 1: " + e.getMessage());
            }
            System.out.println();

            // Minor client tries to make a booking without a guardian
            try {
                System.out.println("\u001B[34mMinor client Paul tries to make a booking without a guardian\u001B[0m");
                Booking booking2 = paul.makeBooking(judoGroupOffering2);
                System.out.println("Booking 2 ID: " + booking2.getBookingID() + ", Status: " + booking2.getStatus() + " - Booking successful");
            } catch (Exception e) {
                System.out.println("Failed to make booking 2: " + e.getMessage());
            }
            System.out.println();

            // Client tries to make another booking with a time conflict
            try {
                System.out.println("\u001B[34mClient tries to make another booking with a time conflict\u001B[0m");
                Booking booking2 = lisa.makeBooking(judoGroupOffering2);
                System.out.println("Booking 2 ID: " + booking2.getBookingID() + ", Status: " + booking2.getStatus() + " - Booking successful");
            } catch (Exception e) {
                System.out.println("Failed to make booking 2: " + e.getMessage());
            }
            System.out.println();

            // Client cancels a booking
            System.out.println("\u001B[34mClient cancels a booking\u001B[0m");
            lisa.cancelBooking(booking1.getBookingID());
            System.out.println("Booking 1 Status after cancellation: " + booking1.getStatus());
            System.out.println();

            // Client tries to make a booking for a private lesson
            try {
                System.out.println("\u001B[34mClient tries to make a booking for a private lesson\u001B[0m");
                Booking booking3 = lisa.makeBooking(judoPrivateOffering1);
                System.out.println("Booking 3 ID: " + booking3.getBookingID() + ", Status: " + booking3.getStatus() + " - Booking successful");
            } catch (Exception e) {
                System.out.println("Failed to make booking 3: " + e.getMessage());
            }
            System.out.println();

            // Client tries to make a booking for a lesson in a different city
            try {
                System.out.println("\u001B[34mClient tries to make a booking for a lesson in a different city\u001B[0m");
                Offering swimmingOffering = new Offering(new Lesson("Swimming"), judoSchedule, new Space("Pool", "Main Building", new Location("Main Building", new City("Toronto", "Ontario"))), Mode.GROUP);
                Booking booking4 = lisa.makeBooking(swimmingOffering);
                System.out.println("Booking 4 ID: " + booking4.getBookingID() + ", Status: " + booking4.getStatus() + " - Booking successful");
            } catch (Exception e) {
                System.out.println("Failed to make booking 4: " + e.getMessage());
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}