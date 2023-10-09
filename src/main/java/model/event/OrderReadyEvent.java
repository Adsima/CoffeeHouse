package model.event;

import model.Order;
import model.status.EventType;

import java.time.LocalDateTime;

public class OrderReadyEvent extends OrderEvent {
    public OrderReadyEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        super(order, employeeId, type, time);
    }

    @Override
    public String toString() {
        return "OrderReadyEvent{} " + super.toString();
    }
}
