package service;

import model.Order;
import model.event.OrderEvent;
import util.MessageConstants;

import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private Map<Long, Order> orderMap;

    public OrderServiceImpl(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    // Список событий будем искать ч/з id - HashMap<Long, List<EventOrder> ordersMap...
    private static final String FIND_ORDER = "...";


    @Override
    public void publishEvent(OrderEvent event) {

    }

    @Override
    public Order findOrder(int id) {
        if (orderMap.containsKey(id)) {
            throw new IllegalArgumentException(MessageConstants.ORDER_NOT_FOUND);
        }
        return orderMap.get(id);
    }
}
