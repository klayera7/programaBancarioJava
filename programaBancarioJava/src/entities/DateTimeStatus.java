package entities;

import java.util.Date;

public class DateTimeStatus {
    private Date transaction;
    private OrderStatus OrderStatus;

    public DateTimeStatus(Date saque, OrderStatus orderStatus) {
        this.transaction = saque;
        OrderStatus = orderStatus;
    }

    public DateTimeStatus(Date saque, Date deposito) {
        this.transaction = saque;
    }

    public Date getSaque() {
        return transaction;
    }

    public void setSaque(Date saque) {
        this.transaction = saque;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        OrderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Horário da transação: " +
                transaction;
    }
}