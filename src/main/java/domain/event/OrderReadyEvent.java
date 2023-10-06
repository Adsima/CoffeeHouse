package domain.event;

import java.time.LocalDateTime;

public class OrderReadyEvent extends OrderEvent {
    public OrderReadyEvent(Long orderId, Long employeeId, LocalDateTime time) {
        super(orderId, employeeId, time);
    }
}
