package implementation_java.organization;

import implementation_java.lessons.Lesson;
import implementation_java.locations.Space;
import implementation_java.offerings.Mode;
import implementation_java.offerings.Offering;
import implementation_java.scheduling.Schedule;
import implementation_java.users.UserAccount;

public class Administrator {
    // Methods

    public Offering makeOffering(Lesson lesson, Schedule schedule, Space space, Mode mode) {
        Offering offering = new Offering(lesson, schedule, space, mode);
        return offering;
    }

    public void createOffering(Organization organization, Offering offering) {
        organization.addOffering(offering);
    }
}
