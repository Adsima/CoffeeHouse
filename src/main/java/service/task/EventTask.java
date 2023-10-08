package service.task;

import exception.OrderException;
import model.Order;
import model.event.*;
import model.status.EventType;
import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventTask {

    private OrderRegisteredEvent registeredEvent;
    private OrderCancelledEvent cancelledEvent;
    private OrderStartedEvent startedEvent;
    private OrderReadyEvent readyEvent;
    private OrderCompletedEvent completedEvent;

    public EventTask() {
    }

    public OrderRegisteredEvent createRegisteredEvent(Order order, Long employeeId, EventType type,
                                      LocalDateTime time, Long clientId, LocalDateTime executedTime,
                                      Long productId, BigDecimal productCost) {
        return new OrderRegisteredEvent(order, employeeId, type, time, clientId,
                executedTime, productId, productCost);
    }

    public void createCancelledEvent(Order order) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {
            System.out.println("TRUE");
        }
        throw new OrderException();
    }

    public OrderStartedEvent createStartedEvent(Order order) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

            return startedEvent;
        }
        throw new OrderException();
    }

    public void createReadyEvent(Order order) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

        }
        throw new OrderException("The order is not registered!");
    }

    public void createCompletedEvent(Order order) {
        if (validateRegistered(order) && checkingForEventCreation(order)) {

        }
        throw new OrderException("The order is not registered!");
    }

    private boolean validateRegistered(Order order) {
        return order.getStatus().equals(OrderStatus.ORDER_REGISTERED);
    }

    private boolean checkingForEventCreation(Order order) {
        return !order.getStatus().equals(OrderStatus.ORDER_CANCELLED) && !order.getStatus().equals(OrderStatus.ORDER_COMPLETED);
    }
}
