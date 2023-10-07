package domain.event;

import domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderStartedEvent extends OrderEvent {
    public OrderStartedEvent(Long orderId, Long employeeId, LocalDateTime time, OrderStatus status) {
        super(orderId, employeeId, time, status);
    }
}
