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

    // Methods
    public void scheduleOffering(Offering offering) {
        // Implement scheduling logic
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
