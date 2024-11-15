package implementation_java.scheduling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    // Attributes
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TimeSlot> timeSlots;

    // Constructor
    public Schedule(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeSlots = new ArrayList<>();
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public void removeTimeSlot(TimeSlot timeSlot) {
        timeSlots.remove(timeSlot);
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public boolean overlapsWith(Schedule other) {
        for (TimeSlot thisSlot : this.timeSlots) {
            for (TimeSlot otherSlot : other.timeSlots) {
                if (thisSlot.overlapsWith(otherSlot)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Getters
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
