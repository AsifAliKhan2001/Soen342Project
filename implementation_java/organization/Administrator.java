public class Administrator {
    // Methods

    public Offering makeOffering(Lesson lesson, Schedule schedule, Space space, Mode mode) {
        Offering offering = new Offering(lesson, schedule, space, mode);
        return offering;
    }

    public void deleteAccount(UserAccount user) {
        // Implement the logic to delete a user account
    }

    public void viewAllRecords() {
        // Implement the logic to view all records
    }

    public void createOffering(Organization organization, Offering offering) {
        organization.addOffering(offering);
    }
}
