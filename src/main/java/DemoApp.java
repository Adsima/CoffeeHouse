import model.Order;
import model.status.OrderStatus;
import service.task.EventTask;

import java.util.ArrayList;

public class DemoApp {
    public static void main(String[] args) {
        EventTask eventTask = new EventTask();

        Order order = new Order(1L, OrderStatus.ORDER_REGISTERED, new ArrayList<>());

        eventTask.createCancelledEvent(order);

    }
}
