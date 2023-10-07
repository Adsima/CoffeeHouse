package service;

import model.Order;
import model.event.OrderEvent;

public class OrderServiceImpl implements OrderService {

    private Order order;

    public OrderServiceImpl(Order order) {
        this.order = order;
    }

    @Override
    public void publishEvent(OrderEvent event) {

    }

    @Override
    public Order findOrder(int id) {
        throw new IllegalArgumentException();
    }
}
