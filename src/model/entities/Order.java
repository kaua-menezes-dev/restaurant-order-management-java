package model.entities;

import model.enums.OrderStatus;
import model.enums.PaymentMethod;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer tableNumber;
    private OrderStatus status;
    private LocalTime time;
    private List<OrderItem> items = new ArrayList<>();
    private PaymentMethod paymentMethod;

    public Order(){}

    public Order(Integer tableNumber) {
        this.tableNumber = tableNumber;
        this.status = OrderStatus.PENDING;
        this.time = LocalTime.now();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public boolean isPending(){
        return status == OrderStatus.PENDING;
    }

    public boolean isPaid(){
        return status == OrderStatus.PAID;
    }
}
