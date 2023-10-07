package model.event;

import model.status.OrderStatus;

import java.time.LocalDateTime;

public class OrderStartedEvent extends OrderEvent {
    public OrderStartedEvent(Long orderId, Long employeeId, OrderStatus status, LocalDateTime time) {
        super(orderId, employeeId, status, time);
    }
}
