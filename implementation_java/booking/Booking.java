public class Booking {
    private String bookingID;
    private Client client;
    private Offering offering;
    private LocalDate bookingDate;
    private BookingStatus status;

    public Booking(Client client, Offering offering) {
        this.bookingID = UUID.randomUUID().toString();
        this.client = client;
        this.offering = offering;
        this.bookingDate = LocalDate.now();
        this.status = BookingStatus.Active;
    }

    public void cancel() throws Exception {
        if (status == BookingStatus.Cancelled) {
            throw new Exception("Booking is already cancelled");
        }
        status = BookingStatus.Cancelled;
    }

    // Getters and Setters
}
