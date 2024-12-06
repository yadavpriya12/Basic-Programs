import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserService {

    private static final String USERNAME_REGEX = "^[a-zA-Z]+$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    // Register a new user
    public void registerUser(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();

        // Validate inputs
        if (!isValidUsername(username)) {
            System.out.println("Invalid username. Only letters are allowed.");
            return;
        }
        if (!isValidPassword(password)) {
            System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one number.");
            return;
        }
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("**************************************");
            System.out.println("User registered successfully!");
            System.out.println("**************************************\n");
        } catch (SQLException e) {
            System.out.println("An error occurred during registration: " + e.getMessage());
        }
    }

    // Validate username (only letters allowed)
    private boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    // Validate password (minimum length and contains at least one number)
    private boolean isValidPassword(String password) {
        return password.length() >= 8 && Pattern.compile("[0-9]").matcher(password).find();
    }

    // Check if username is already taken
    private boolean isUsernameTaken(String username) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while checking username: " + e.getMessage());
        }
        return false;
    }

    // Login a user
    public User loginUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return null;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
            } else {
                System.out.println("Invalid username or password.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred during login: " + e.getMessage());
            return null;
        }
    }

    // Update user information
    public void updateUserInfo(int userId, Scanner sc) {
        if (userId <= 0) {
            System.out.println("Invalid user ID.");
            return;
        }

        System.out.print("Enter new username: ");
        String newUsername = sc.nextLine().trim();
        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine().trim();

        if (!isValidUsername(newUsername)) {
            System.out.println("Invalid username. Only letters are allowed.");
            return;
        }
        if (!isValidPassword(newPassword)) {
            System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one number.");
            return;
        }
        if (isUsernameTaken(newUsername)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE users SET username = ?, password = ? WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newUsername);
            ps.setString(2, newPassword);
            ps.setInt(3, userId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User information updated successfully!");
            } else {
                System.out.println("User not found or no changes made.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while updating user information: " + e.getMessage());
        }
    }

    // View order history for a user
    public void viewOrderHistory(int userId) {
        if (userId <= 0) {
            System.out.println("Invalid user ID.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT order_id, status, order_date, delivery_time FROM orders WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            boolean hasOrders = false; // Flag to check if there are any orders

            System.out.println("Order History:");

            while (rs.next()) {
                if (!hasOrders) {
                    hasOrders = true; // Set the flag to true if at least one order is found
                }

                int orderId = rs.getInt("order_id");
                String status = rs.getString("status");
                Timestamp orderDate = rs.getTimestamp("order_date");
                Timestamp deliveryTime = rs.getTimestamp("delivery_time");

                String formattedOrderDate = (orderDate != null) ? orderDate.toString() : "N/A";
                String formattedDeliveryTime = (deliveryTime != null) ? deliveryTime.toString() : "30 minutes";

                System.out.println("Order ID: " + orderId + " | Status: " + status +
                        " | Order Date: " + formattedOrderDate +
                        " | Delivery Time: " + formattedDeliveryTime);
            }

            if (!hasOrders) {
                System.out.println("You did not order anything.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving order history: " + e.getMessage());
        }
    }
}
