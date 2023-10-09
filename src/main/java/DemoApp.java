import model.Order;
import model.event.OrderRegisteredEvent;
import service.OrderServiceImpl;
import service.task.OrderCreatedEvent;

import java.math.BigDecimal;

public class DemoApp {

    static OrderServiceImpl orderService = new OrderServiceImpl();
    static OrderCreatedEvent createdEvent = new OrderCreatedEvent();

    public static void main(String[] args) {
        Order order = new Order(1L);
        OrderRegisteredEvent registeredEvent = createdEvent.createRegisteredEvent(order, 1L, 2L, 10L, 1L, BigDecimal.valueOf(10));
        orderService.publishEvent(registeredEvent);
    }
}
