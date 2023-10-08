package service.task;

import dao.EventDao;
import model.Order;
import model.event.OrderRegisteredEvent;
import model.status.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventService {

    private EventDao eventDao;
    private OrderCreatedEvent createdEvent;

    public EventService() {
        createdEvent = new OrderCreatedEvent();
        eventDao = new EventDao();
    }

    public void registeredEvent(Order order, Long employeeId, EventType type,
                                LocalDateTime time, Long clientId, LocalDateTime executedTime,
                                Long productId, BigDecimal productCost) {
        var registered = createdEvent.createRegisteredEvent(order, employeeId, type, time, clientId,
                executedTime, productId, productCost);
        eventDao.saveRegisteredEvent(registered);
    }

    public void cancelledEvent(Order order, Long employeeId, EventType type,
                               LocalDateTime time, String reason) {
        var cancelled = createdEvent.createCancelledEvent(order, employeeId, type, time, reason);
        eventDao.saveCancelledEvent(cancelled);
    }

    public void startedEvent(Order order, Long employeeId,
                             EventType type, LocalDateTime time) {
        var started = createdEvent.createStartedEvent(order, employeeId, type, time);
        eventDao.saveStartedEvent(started);
    }

    public void readyEvent(Order order, Long employeeId,
                           EventType type, LocalDateTime time) {
        var ready = createdEvent.createReadyEvent(order, employeeId, type, time);
        eventDao.saveReadyEvent(ready);
    }

    public void completedEvent(Order order, Long employeeId,
                               EventType type, LocalDateTime time) {
        var completed = createdEvent.createCompletedEvent(order, employeeId, type, time);
        eventDao.saveCompletedEvent(completed);
    }



}
