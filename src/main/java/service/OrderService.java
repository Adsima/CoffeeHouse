package service;

import domain.Order;
import domain.event.OrderEvent;

public interface OrderService {
    void publishEvent(OrderEvent event);

    Order findOrder(int id);
}
