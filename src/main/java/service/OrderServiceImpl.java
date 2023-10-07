package service;

import domain.Order;
import domain.event.OrderEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    Map<Long, Order> orderMap;

    public OrderServiceImpl() {
        orderMap = new HashMap<>();
    }

    @Override
    public void publishEvent(OrderEvent event) {

    }

    @Override
    public Order findOrder(int id) {
        if (!orderMap.containsKey(id)) {
            throw new IllegalArgumentException("Заказ не найден!");
        }
        return orderMap.get(id);
    }
}
