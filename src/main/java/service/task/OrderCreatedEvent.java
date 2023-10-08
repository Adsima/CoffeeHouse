package service.task;

import exception.OrderException;
import model.Order;
import model.event.*;
import model.status.EventType;
import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderCreatedEvent {

    private OrderRegisteredEvent registeredEvent;
    private OrderCancelledEvent cancelledEvent;
    private OrderStartedEvent startedEvent;
    private OrderReadyEvent readyEvent;
    private OrderCompletedEvent completedEvent;

    public OrderCreatedEvent() {
    }

    public OrderRegisteredEvent createRegisteredEvent(Order order, Long employeeId, EventType type,
                                      LocalDateTime time, Long clientId, LocalDateTime executedTime,
                                      Long productId, BigDecimal productCost) {
        return new OrderRegisteredEvent(order, employeeId, type, time, clientId,
                executedTime, productId, productCost);
    }

    public OrderCancelledEvent createCancelledEvent(Order order, Long employeeId, EventType type,
                                                    LocalDateTime time, String reason) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

            return new OrderCancelledEvent(order, employeeId, type, time, reason);
        }
        throw new OrderException("Order error!");
    }

    public OrderStartedEvent createStartedEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

            return new OrderStartedEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    public OrderReadyEvent createReadyEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

            return new OrderReadyEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    public OrderStartedEvent createCompletedEvent(Order order, Long employeeId, EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

            return new OrderStartedEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    private boolean validateRegistered(Order order) {
        return order.getStatus().equals(OrderStatus.ORDER_REGISTERED);
    }

    private boolean checkingForEventCreation(Order order) {
        return !order.getStatus().equals(OrderStatus.ORDER_CANCELLED) && !order.getStatus().equals(OrderStatus.ORDER_COMPLETED);
    }
}
