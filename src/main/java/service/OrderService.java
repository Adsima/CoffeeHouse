package service;

import model.Order;
import model.event.OrderEvent;

public interface OrderService {

    void publishEvent(OrderEvent event);

    Order findOrder(int id);
}
