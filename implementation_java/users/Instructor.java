package implementation_java.users;

import implementation_java.lessons.Specialization;
import implementation_java.locations.City;
import implementation_java.offerings.Offering;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends UserAccount {
    // Attributes
    private List<Specialization> specializations;
    private List<City> availability;
    private List<Offering> offerings; // Keep track of offerings selected

    // Constructor
    public Instructor(String username, String password, String name, String phoneNumber) {
        super(username, password, name, phoneNumber);
        this.specializations = new ArrayList<>();
        this.availability = new ArrayList<>();
        this.offerings = new ArrayList<>();
    }

    // Methods
    public void selectOffering(Offering offering) {
        this.offerings.add(offering);
    }

    public void updateAvailability(List<City> cities) {
        this.availability = cities;
    }

    public void addSpecialization(Specialization specialization) {
        this.specializations.add(specialization);
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    @Override
    public void register() {
        // Implement registration logic
    }

    @Override
    public void login() {
        // Implement login logic
    }

    @Override
    public void logout() {
        // Implement logout logic
    }

    // Getters and Setters
    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public List<City> getAvailability() {
        return availability;
    }
}
