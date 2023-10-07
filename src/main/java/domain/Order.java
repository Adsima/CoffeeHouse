package domain;

import domain.event.OrderEvent;

import java.util.List;

public class Order {
    private Long orderId;
    private OrderStatus status;
    private List<OrderEvent> eventList;

    public Order(Long orderId, OrderStatus status, List<OrderEvent> eventList) {
        this.orderId = orderId;
        this.status = status;
        this.eventList = eventList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<OrderEvent> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", eventList=" + eventList +
                '}';
    }
}
