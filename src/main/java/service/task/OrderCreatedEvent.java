package service.task;

import exception.OrderException;
import model.Order;
import model.event.*;
import model.status.EventType;
import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static util.MessageConstants.NOT_REGISTERED_OR_CLOSED;

public final class OrderCreatedEvent {

    public OrderCreatedEvent() {}

    public OrderRegisteredEvent createRegisteredEvent(Order order, Long employeeId,
                                      LocalDateTime time, Long clientId, LocalDateTime executedTime,
                                      Long productId, BigDecimal productCost) {
        order.setStatus(OrderStatus.ORDER_REGISTERED);
        return new OrderRegisteredEvent(order, employeeId, EventType.REGISTERED, time, clientId,
                executedTime, productId, productCost);
    }

    public OrderCancelledEvent createCancelledEvent(Order order, Long employeeId,
                                                    LocalDateTime time, String reason) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_CANCELLED);
            return new OrderCancelledEvent(order, employeeId, EventType.CANCELLED, time, reason);
        }
        throw new OrderException(NOT_REGISTERED_OR_CLOSED);
    }

    public OrderStartedEvent createStartedEvent(Order order, Long employeeId, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_STARTED);
            return new OrderStartedEvent(order, employeeId, EventType.STARTED, time);
        }
        throw new OrderException(NOT_REGISTERED_OR_CLOSED);
    }

    public OrderReadyEvent createReadyEvent(Order order, Long employeeId, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_READY);
            return new OrderReadyEvent(order, employeeId, EventType.READY, time);
        }
        throw new OrderException(NOT_REGISTERED_OR_CLOSED);
    }

    public OrderCompletedEvent createCompletedEvent(Order order, Long employeeId, LocalDateTime time) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            order.setStatus(OrderStatus.ORDER_COMPLETED);
            return new OrderCompletedEvent(order, employeeId, EventType.COMPLETED, time);
        }
        throw new OrderException(NOT_REGISTERED_OR_CLOSED);
    }

    private boolean validateRegistered(Order order) {
        return order.getStatus().equals(OrderStatus.ORDER_REGISTERED);
    }

    private boolean checkingForEventCreation(Order order) {
        return !order.getStatus().equals(OrderStatus.ORDER_CANCELLED)
                && !order.getStatus().equals(OrderStatus.ORDER_COMPLETED);
    }
}
