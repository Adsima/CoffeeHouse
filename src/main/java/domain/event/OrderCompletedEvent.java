package domain.event;

import domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderCompletedEvent extends OrderEvent {
    public OrderCompletedEvent(Long orderId, Long employeeId, LocalDateTime time, OrderStatus status) {
        super(orderId, employeeId, time, status);
    }
}
