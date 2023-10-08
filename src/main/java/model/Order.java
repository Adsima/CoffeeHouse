package model;

import model.event.OrderEvent;
import model.status.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long orderId;
    private OrderStatus status;

    private List<OrderEvent> eventList = new ArrayList<>();

    public Order(Long id) {
        orderId = id;
    }

    public Order(Long orderId, OrderStatus status, List<OrderEvent> eventList) {
        this.orderId = orderId;
        this.status = status;
        this.eventList = eventList;
    }

    public void addEventToList(OrderEvent orderEvent) {
        eventList.add(orderEvent);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && status == order.status && Objects.equals(eventList, order.eventList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, eventList);
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
