package model.event;

import model.status.OrderStatus;

import java.time.LocalDateTime;

public class OrderReadyEvent extends OrderEvent {
    public OrderReadyEvent(Long orderId, Long employeeId, OrderStatus status, LocalDateTime time) {
        super(orderId, employeeId, status, time);
    }
}
