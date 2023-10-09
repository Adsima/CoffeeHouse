package model.event;

import model.Order;
import model.status.EventType;

import java.time.LocalDateTime;

public class OrderStartedEvent extends OrderEvent {
    public OrderStartedEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        super(order, employeeId, type, time);
    }

    @Override
    public String toString() {
        return "OrderStartedEvent{} " + super.toString();
    }
}
