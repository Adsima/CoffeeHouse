import model.Order;
import service.OrderServiceImpl;
import service.task.OrderCreatedEvent;

public class OrderStarter {
    private OrderServiceImpl orderService;
    private OrderCreatedEvent createdEvent;

    public OrderStarter() {
        orderService = new OrderServiceImpl();
        createdEvent = new OrderCreatedEvent();
    }

    public static void main(String[] args) {
        new OrderStarter()
                .buildOrder(1L);
    }

    private Order buildOrder(Long id) {
        Order order = new Order(id);
        orderService.addOrderToMap(order);
        return order;
    }

}
