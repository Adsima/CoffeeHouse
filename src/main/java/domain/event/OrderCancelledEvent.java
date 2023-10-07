package domain.event;

import domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderCancelledEvent extends OrderEvent {
    private String reason;

    public OrderCancelledEvent(Long orderId, Long employeeId, LocalDateTime time, String reason, OrderStatus status) {
        super(orderId, employeeId, time, status);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "OrderCancelledEvent{" +
                "reason='" + reason + '\'' +
                '}';
    }
}
