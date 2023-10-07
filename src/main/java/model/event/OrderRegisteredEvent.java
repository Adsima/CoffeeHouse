package model.event;

import model.status.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderRegisteredEvent extends OrderEvent {
    private Long clientId;
    private LocalDateTime executedTime;
    private Long productId;
    private BigDecimal productCost;

    public OrderRegisteredEvent(Long orderId, Long employeeId, OrderStatus status, LocalDateTime time, Long clientId,
                                LocalDateTime executedTime, Long productId, BigDecimal productCost) {
        super(orderId, employeeId, status, time);
        this.clientId = clientId;
        this.executedTime = executedTime;
        this.productId = productId;
        this.productCost = productCost;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(LocalDateTime executedTime) {
        this.executedTime = executedTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return "OrderRegisteredEvent{" +
                "clientId=" + clientId +
                ", executedTime=" + executedTime +
                ", productId=" + productId +
                ", productCost=" + productCost +
                '}';
    }
}
