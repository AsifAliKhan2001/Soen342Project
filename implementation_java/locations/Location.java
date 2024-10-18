import java.util.ArrayList;
import java.util.List;

public class Location {
    // Attributes
    private String address;
    private List<Space> spaces;
    private City city; // Location is located in a City

    // Constructor
    public Location(String address, City city) {
        this.address = address;
        this.spaces = new ArrayList<>();
        this.city = city;
    }

    // Methods
    public void addSpace(Space space) {
        spaces.add(space);
    }

    public void removeSpace(Space space) {
        spaces.remove(space);
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }
}
