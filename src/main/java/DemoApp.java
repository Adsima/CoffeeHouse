import model.Order;
import model.status.OrderStatus;
import service.task.OrderCreatedEvent;

import java.util.ArrayList;

public class DemoApp {
    public static void main(String[] args) {
        OrderCreatedEvent eventTask = new OrderCreatedEvent();

        Order order = new Order(1L, OrderStatus.ORDER_REGISTERED, new ArrayList<>());



    }
}
