package domain.event;

import domain.OrderStatus;

import java.time.LocalDateTime;

public abstract class OrderEvent {
    private Long orderId;
    private Long employeeId;
    private LocalDateTime time;
    private OrderStatus status;

    public OrderEvent() {}

    public OrderEvent(Long orderId, Long employeeId, LocalDateTime time, OrderStatus status) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.time = time;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "orderId=" + orderId +
                ", employeeId=" + employeeId +
                ", time=" + time +
                '}';
    }
}
