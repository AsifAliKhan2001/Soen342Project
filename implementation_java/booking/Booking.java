package implementation_java.booking;

import implementation_java.offerings.Offering;
import implementation_java.users.Client;

import java.time.LocalDate;
import java.util.UUID;

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

    public String getBookingID() {
        return bookingID;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Offering getOffering() {
        return offering;
    }
}
