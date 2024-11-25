import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int userId;
    private Timestamp orderDate;
    private String status;
    private Timestamp deliveryTime;

    public Order(int orderId, int userId, Timestamp orderDate, String status, Timestamp deliveryTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryTime = deliveryTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }
}
