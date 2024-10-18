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

    // Methods
    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public void removeTimeSlot(TimeSlot timeSlot) {
        timeSlots.remove(timeSlot);
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    // Getters
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
