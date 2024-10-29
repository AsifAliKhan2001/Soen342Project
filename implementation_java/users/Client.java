public class Client {
    private String clientID;
    private String name;
    private int age;
    private String phoneNumber;
    private Guardian guardian; // Nullable
    private List<Booking> bookings;

    public Client(String name, int age, String phoneNumber, Guardian guardian) {
        this.clientID = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.guardian = guardian;
        this.bookings = new ArrayList<>();
    }

    public Booking makeBooking(Offering offering) throws Exception {
        if (!offering.isAvailable()) {
            throw new Exception("Offering is not available");
        }

        // Check for time conflicts
        for (Booking b : bookings) {
            if (b.getStatus() == BookingStatus.Active &&
                    b.getOffering().getSchedule().overlapsWith(offering.getSchedule())) {
                throw new Exception("Time conflict with existing booking");
            }
        }

        // Check for guardian if underage
        if (age < 18 && guardian == null) {
            throw new Exception("Underage clients must have a guardian");
        }

        offering.markAsBooked();
        Booking booking = new Booking(this, offering);
        bookings.add(booking);
        return booking;
    }

    public void cancelBooking(String bookingID) throws Exception {
        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getBookingID().equals(bookingID)) {
                booking = b;
                break;
            }
        }

        if (booking == null || booking.getStatus() == BookingStatus.Cancelled) {
            throw new Exception("Booking not found or already cancelled");
        }

        booking.cancel();
        offering.markAsAvailable();
    }

    // Getters and Setters
}
