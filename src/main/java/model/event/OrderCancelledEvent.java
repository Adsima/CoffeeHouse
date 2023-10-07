package model.event;

import model.Order;
import model.status.EventType;
import java.time.LocalDateTime;

public class OrderCancelledEvent extends OrderEvent {
    private String reason;

    public OrderCancelledEvent(Order order, Long employeeId, EventType type, LocalDateTime time, String reason) {
        super(order, employeeId, type, time);
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
