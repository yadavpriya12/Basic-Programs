import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CartService {
    Scanner sc = new Scanner(System.in);

    // Method to add a product to the cart
    public void addToCart(int userId, int productId, int quantity) {
        // Validate inputs
        if (userId <= 0 || productId <= 0 || quantity <= 0) {
            System.out.println("Invalid input: userId, productId, and quantity must be greater than 0.");
            return;
        }

        // Execute database operation
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, productId);
                ps.setInt(3, quantity);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Product added to cart successfully.");
                } else {
                    System.out.println("Failed to add product to cart. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while adding to cart: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to view the cart
    public void viewCart(int userId) {
        // Validate input
        if (userId <= 0) {
            System.out.println("Invalid userId. It must be greater than 0.");
            return;
        }

        // Execute database operation
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT cart.cart_id, products.product_name, cart.quantity, products.price FROM cart "
                    + "JOIN products ON cart.product_id = products.product_id WHERE cart.user_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    double totalPrice = 0;
                    System.out.println("Your Cart:");
                    if (!rs.isBeforeFirst()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        while (rs.next()) {
                            int cartId = rs.getInt("cart_id");
                            String productName = rs.getString("product_name");
                            int quantity = rs.getInt("quantity");
                            double price = rs.getDouble("price");
                            totalPrice += price * quantity;
                            System.out.println("Cart ID: " + cartId + " | Product: " + productName + " | Quantity: " + quantity
                                    + " | Price: $" + price);
                        }
                        System.out.println("Total Price: $" + totalPrice);
                        System.out.println("Enter 1 if you want to delete any item from your cart ");
                        int del = sc.nextInt();
                        if (del == 1) {
                            System.out.println("Enter the Cart ID of the item to delete: ");
                            int cartId = sc.nextInt();
                            deleteCartItem(cartId);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while viewing cart: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to delete an item from the cart
    public void deleteCartItem(int cartId) {
        // Validate input
        if (cartId <= 0) {
            System.out.println("Invalid cartId. It must be greater than 0.");
            return;
        }

        // Execute database operation
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM cart WHERE cart_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, cartId);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Item removed from cart.");
                } else {
                    System.out.println("No item found with the given cartId.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while deleting cart item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to check if the cart is empty
    public boolean isCartEmpty(int userId) {
        // Validate input
        if (userId <= 0) {
            System.out.println("Invalid userId. It must be greater than 0.");
            return true; // Default to empty if userId is invalid
        }

        // Execute database operation
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM cart WHERE user_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) == 0;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while checking if cart is empty: " + e.getMessage());
            e.printStackTrace();
        }
        return true; // Default to empty if error occurs
    }

    // Method to place an order
    public void placeOrder(int userId) throws SQLException {
        // Validate input
        if (userId <= 0) {
            System.out.println("Invalid userId. It must be greater than 0.");
            return;
        }

        if (isCartEmpty(userId)) {
            System.out.println("Cannot place order. The cart is empty.");
            return;
        }

        String contact = "";
        String address = "";
    
        // Capture and validate contact and address
        if (userId > 0) {
            boolean isValidContact = false;
    
            // Keep asking for valid contact number until a valid one is provided
            while (!isValidContact) {
                System.out.println("Enter your 10-digit Contact Number: ");
                contact = sc.nextLine();
                
                // Check if the input is exactly 10 digits and all numeric
                if (contact.matches("\\d{10}")) {
                    isValidContact = true;
                } else {
                    System.out.println("Invalid contact number. Please enter exactly 10 digits.");
                }
            }

            System.out.println("Enter your Address: ");
            address = sc.nextLine();
        }

        // Execute database operation
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false); // Start transaction

            // Insert the order
            String query = "INSERT INTO orders(user_id, status, contact, address) VALUES(?, 'Pending', ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setString(2, contact);
                ps.setString(3, address);
                ps.executeUpdate();
            }

            // Optionally, handle order items and update stock here

            // Commit transaction
            con.commit();
            System.out.println("Order placed successfully.");
        } catch (SQLException e) {
            System.err.println("Error while placing order: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
