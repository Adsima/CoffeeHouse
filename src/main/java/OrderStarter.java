import dao.EventDao;
import dao.OrderDao;
import model.Order;
import service.OrderServiceImpl;

public class OrderStarter {

    private Order order;
    private OrderDao orderDao;
    private EventDao eventDao;

    private OrderServiceImpl orderService;


    public OrderStarter() {
        orderDao = OrderDao.getInstance();
        eventDao = EventDao.getInstance();

        orderService = new OrderServiceImpl();

    }

    public static void main(String[] args) {
        new OrderStarter()
                .start();
    }

    private void start() {
        order = createOrder();
        Order saveOrder = orderDao.saveOrder(order);

        orderService.addOrderToMap(saveOrder);


    }

    private Order createOrder() {
        return new Order();
    }
}
