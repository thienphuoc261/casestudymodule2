package service;

import java.util.UUID;

public class OrderResponse {
    private String orderId;
    private boolean isAccepted;
    private String message;
    private boolean isDelivered;

    public OrderResponse(boolean isAccepted, String message, boolean isDelivered) {
        this.orderId = UUID.randomUUID().toString();
        this.isAccepted = isAccepted;
        this.message = message;
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderId='" + orderId + '\'' +
                ", isAccepted=" + isAccepted +
                ", message='" + message + '\'' +
                '}';
    }
}
