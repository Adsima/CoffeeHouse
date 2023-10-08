package model;

import dao.OrderDao;
import model.event.OrderEvent;
import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Order {

    private Long orderId;
    private OrderStatus status;
    private List<OrderEvent> eventList;

    private OrderDao dao;

    public Order(Long orderId, OrderStatus status, List<OrderEvent> eventList) {
        this.orderId = orderId;
        this.status = status;
        this.eventList = eventList;
    }

    public void createEvent(Long clientId, Long employeeId, LocalTime expectedTime, Long productId,
                            BigDecimal price, LocalDateTime dateTime) {

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
