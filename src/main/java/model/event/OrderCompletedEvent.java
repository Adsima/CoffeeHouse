package model.event;

import model.status.OrderStatus;

import java.time.LocalDateTime;

public class OrderCompletedEvent extends OrderEvent {
    public OrderCompletedEvent(Long orderId, Long employeeId, OrderStatus status, LocalDateTime time) {
        super(orderId, employeeId, status, time);
    }
}
