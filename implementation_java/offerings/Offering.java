package implementation_java.offerings;

import implementation_java.lessons.Lesson;
import implementation_java.locations.Space;
import implementation_java.scheduling.Schedule;
import implementation_java.users.Instructor;

public class Offering {
    // Attributes
    private boolean available;
    private Lesson lesson;     // Is for a Lesson
    private Mode mode;         // Has a Mode
    private Schedule schedule; // Scheduled at a Schedule
    private Space space;       // Located in a Space
    private Instructor instructor; // Assigned to an Instructor

    // Constructor
    public Offering(Lesson lesson, Schedule schedule, Space space, Mode mode) {
        this.lesson = lesson;
        this.schedule = schedule;
        this.space = space;
        this.mode = mode;
        this.available = true;
        this.instructor = null;
    }

    // Methods
    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void updateAvailability(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Mode getMode() {
        return mode;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Space getSpace() {
        return space;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void markAsAvailable() {
        this.available = true;
    }

    public void markAsBooked() {
        this.available = false;
    }
}
