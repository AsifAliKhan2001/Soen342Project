package implementation_java.scheduling;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeSlot {
    // Attributes
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // Constructor
    public TimeSlot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlapsWith(TimeSlot other) {
        return this.dayOfWeek == other.dayOfWeek &&
                this.startTime.isBefore(other.endTime) &&
                this.endTime.isAfter(other.startTime);
    }
}
