package implementation_java.locations;

import implementation_java.offerings.Offering;

public class Space {
    // Attributes
    private String type; // e.g., gym, room, swimming pool
    private String name;
    private Location location; // Space is located at a Location

    // Constructor
    public Space(String name, String type, Location location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public String getName() {
        return name;
    }

}
