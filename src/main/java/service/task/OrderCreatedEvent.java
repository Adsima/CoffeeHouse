package service.task;

import exception.OrderException;
import model.Order;
import model.event.*;
import model.status.EventType;
import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class OrderCreatedEvent {

    public OrderCreatedEvent() {
    }

    public static OrderRegisteredEvent createRegisteredEvent(Order order, Long employeeId, EventType type,
                                      LocalDateTime time, Long clientId, LocalDateTime executedTime,
                                      Long productId, BigDecimal productCost) {
        order.setStatus(OrderStatus.ORDER_REGISTERED);
        return new OrderRegisteredEvent(order, employeeId, type, time, clientId,
                executedTime, productId, productCost);
    }

    public static OrderCancelledEvent createCancelledEvent(Order order, Long employeeId, EventType type,
                                                    LocalDateTime time, String reason) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_CANCELLED);
            return new OrderCancelledEvent(order, employeeId, type, time, reason);
        }
        throw new OrderException("Order error!");
    }

    public static OrderStartedEvent createStartedEvent(Order order, Long employeeId,
                                                       EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_STARTED);
            return new OrderStartedEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    public static OrderReadyEvent createReadyEvent(Order order, Long employeeId,
                                                   EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_READY);
            return new OrderReadyEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    public static OrderStartedEvent createCompletedEvent(Order order, Long employeeId,
                                                         EventType type, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_COMPLETED);
            return new OrderStartedEvent(order, employeeId, type, time);
        }
        throw new OrderException("Order error!");
    }

    private static boolean validateRegistered(Order order) {
        return order.getStatus().equals(OrderStatus.ORDER_REGISTERED);
    }

    private static boolean checkingForEventCreation(Order order) {
        return !order.getStatus().equals(OrderStatus.ORDER_CANCELLED)
                && !order.getStatus().equals(OrderStatus.ORDER_COMPLETED);
    }
}
