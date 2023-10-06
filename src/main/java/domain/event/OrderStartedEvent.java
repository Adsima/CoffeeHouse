package domain.event;

import java.time.LocalDateTime;

public class OrderStartedEvent extends OrderEvent {
    public OrderStartedEvent(Long orderId, Long employeeId, LocalDateTime time) {
        super(orderId, employeeId, time);
    }
}
