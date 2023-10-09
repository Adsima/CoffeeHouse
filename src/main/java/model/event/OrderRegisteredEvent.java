package model.event;

import model.Order;
import model.status.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderRegisteredEvent extends OrderEvent {
    private Long clientId;
    private LocalDateTime executedTime;
    private Long productId;
    private BigDecimal productCost;

    public OrderRegisteredEvent(Order order, Long employeeId, EventType type, LocalDateTime time, Long clientId,
                                LocalDateTime executedTime, Long productId, BigDecimal productCost) {
        super(order, employeeId, type, time);
        this.clientId = clientId;
        this.executedTime = executedTime;
        this.productId = productId;
        this.productCost = productCost;
    }

    public Long getClientId() {
        return clientId;
    }

    public LocalDateTime getExecutedTime() {
        return executedTime;
    }

    public Long getProductId() {
        return productId;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    @Override
    public String toString() {
        return "OrderRegisteredEvent{" +
                "clientId=" + clientId +
                ", executedTime=" + executedTime +
                ", productId=" + productId +
                ", productCost=" + productCost +
                "} " + super.toString();
    }
}
