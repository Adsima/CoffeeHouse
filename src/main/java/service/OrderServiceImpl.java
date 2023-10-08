package service;

import model.Order;
import model.event.OrderEvent;
import util.MessageConstants;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private Map<Long, Order> orderMap = new HashMap<>();

    public OrderServiceImpl() {}

    @Override
    public void publishEvent(OrderEvent event) {
        for (Long aLong : orderMap.keySet()) {
            
        }
    }

    @Override
    public Order findOrder(int id) {
        if (orderMap.containsKey(id)) {
            throw new IllegalArgumentException(MessageConstants.ORDER_NOT_FOUND);
        }
        return orderMap.get(id);
    }

    public void addOrderToMap(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    public Map<Long, Order> getOrderMap() {
        return orderMap;
    }
}
