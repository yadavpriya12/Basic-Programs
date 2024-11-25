import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DeliveryService {

    public void updateOrderStatus(int orderId, String status, Timestamp deliveryTime) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE orders SET status = ?, delivery_time = ? WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, status);
            ps.setTimestamp(2, deliveryTime);
            ps.setInt(3, orderId);
            ps.executeUpdate();
            System.out.println("Order status updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkDeliveryStatus(int orderId) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT status, delivery_time FROM orders WHERE order_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                Timestamp deliveryTime = rs.getTimestamp("delivery_time");
                System.out
                        .println("Order ID: " + orderId + " | Status: " + status + " | Delivery Time: " + deliveryTime);
            } else {
                System.out.println("Order not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
