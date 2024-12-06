public class User {
    private int userId;
    private String username;
    private String password;
    private String phoneNumber;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;

    }


   

    // Constructor
    public User(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    // Getter for username
    

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Optionally, you can add setters if needed
}
