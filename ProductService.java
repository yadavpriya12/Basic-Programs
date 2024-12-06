import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    // Method to get products by category name
    private List<Product> getProductsByCategoryName(String category) {
        List<Product> products = new ArrayList<>();
        if (category == null || category.trim().isEmpty()) {
            LOGGER.log(Level.WARNING, "Category must not be null or empty.");
            return products; // Return an empty list if invalid category
        }

        String query = "SELECT * FROM products WHERE category = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, category);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product(rs.getInt("product_id"), rs.getString("product_name"),
                            rs.getString("category"), rs.getDouble("price"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving products by category", e);
        }
        return products;
    }

    // Method to get products by category index
    public List<Product> getProductsByCategoryIndex(int index) {
        List<String> categories = getCategories(); // Retrieve all categories
        if (index < 1 || index > categories.size()) {
            LOGGER.log(Level.WARNING, "Invalid category index: " + index);
            return new ArrayList<>(); // Return an empty list if the index is out of range
        }

        String category = categories.get(index - 1); // Convert 1-based index to 0-based index
        return getProductsByCategoryName(category); // Fetch products by category name
    }

    // Method to get product by ID
    public Product getProductById(int productId) {
        if (productId <= 0) {
            LOGGER.log(Level.WARNING, "Product ID must be greater than zero.");
            return null; // Return null if invalid product ID
        }

        Product product = null;
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = new Product(rs.getInt("product_id"), rs.getString("product_name"),
                            rs.getString("category"), rs.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving product by ID", e);
        }
        if (product == null) {
            LOGGER.log(Level.INFO, "Product not found with ID: " + productId);
        }
        return product;
    }

    // Method to get distinct categories
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        String query = "SELECT DISTINCT category FROM products";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);

             
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving categories", e);
        }
        return categories;
    }
}
