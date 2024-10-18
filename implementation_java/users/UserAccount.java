public abstract class UserAccount {
    // Attributes
    protected String username;
    protected String password;
    protected String name;
    protected String phoneNumber;

    // Constructor
    public UserAccount(String username, String password, String name, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Methods
    public abstract void register();
    public abstract void login();
    public abstract void logout();

    public void updateDetails(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Similarly for other attributes
}
