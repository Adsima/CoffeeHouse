package domain.event;

import domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderReadyEvent extends OrderEvent {
    public OrderReadyEvent(Long orderId, Long employeeId, LocalDateTime time, OrderStatus status) {
        super(orderId, employeeId, time, status);
    }
}
