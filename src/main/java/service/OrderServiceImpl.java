package service;

import dao.EventDao;
import model.Order;
import model.event.*;
import util.MessageConstants;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private Map<Long, Order> orderMap;
    private EventDao eventDao;

    public OrderServiceImpl() {
        orderMap = new HashMap<>();
        eventDao = new EventDao();
    }

    @Override
    public void publishEvent(OrderEvent event) {
        switch (event.getType()) {
            case REGISTERED:
                eventDao.saveRegisteredEvent((OrderRegisteredEvent) event);
                break;
            case CANCELLED:
                eventDao.saveCancelledEvent((OrderCancelledEvent) event);
                break;
            case STARTED:
                eventDao.saveStartedEvent((OrderStartedEvent) event);
                break;
            case READY:
                eventDao.saveReadyEvent((OrderReadyEvent) event);
                break;
            case COMPLETED:
                eventDao.saveCompletedEvent((OrderCompletedEvent) event);
                break;
        }
        event.getOrder().addEventToList(event);
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
