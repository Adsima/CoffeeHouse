package model.event;

import model.Order;
import model.status.EventType;

import java.time.LocalDateTime;

public abstract class OrderEvent {
    private Order order;
    private Long employeeId;
    private EventType type;
    private LocalDateTime time;

    public OrderEvent() {}

    public OrderEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        this.order = order;
        this.employeeId = employeeId;
        this.type = type;
        this.time = time;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "order=" + order +
                ", employeeId=" + employeeId +
                ", type=" + type +
                ", time=" + time +
                '}';
    }
}
