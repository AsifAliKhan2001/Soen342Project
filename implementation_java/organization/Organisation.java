package organization;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    // Attributes
    private String name;
    private List<Offering> offerings;
    private Administrator administrator;

    // Constructor
    public Organization(String name, Administrator administrator) {
        this.name = name;
        this.administrator = administrator;
        this.offerings = new ArrayList<>();
    }

    // Methods
    public void addOffering(Offering offering) {
        offerings.add(offering);
    }

    public void removeOffering(Offering offering) {
        offerings.remove(offering);
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}
