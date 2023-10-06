package domain.event;

import java.time.LocalDateTime;

public class OrderCompletedEvent extends OrderEvent {
    public OrderCompletedEvent(Long orderId, Long employeeId, LocalDateTime time) {
        super(orderId, employeeId, time);
    }
}
