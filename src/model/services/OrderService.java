package model.services;

import model.entities.MenuItem;
import model.entities.Order;
import model.entities.OrderItem;
import model.exceptions.InvalidQuantityException;
import model.exceptions.InvalidTableException;

import java.time.LocalTime;

public class OrderService {

    public Order createOrder(int tableNumber) {

        validateTable(tableNumber);
        Order order = new Order(tableNumber);

        return order;

    }

    public void addItem(Order order, MenuItem item, int quantity) {

        validateQuantity(quantity);

        OrderItem orderItem = new OrderItem(quantity, item);
        order.addItem(orderItem);

    }

    public double calculatedSubtotal(Order order) {

        double sum = 0.0;

        for (OrderItem o : order.getItems()) {
            sum += o.getSubtotal();
        }

        return sum;

    }

    public double calculatedDiscount(Order order) {

        if (isHappyHour(order.getTime())) {
            return calculateBeverageDiscount(order);
        }

        return 0.0;

    }

    public double calculatedServiceFee(Order order) {
        return calculatedSubtotal(order) * 0.10;
    }

    public double calculateTotal(Order order) {
        return calculatedSubtotal(order) + calculatedServiceFee(order) - calculatedDiscount(order);
    }

    private boolean isHappyHour(LocalTime time) {

        int hours = time.getHour();

        if (hours >= 15 && hours <= 17) {
            return true;
        }

        return false;

    }

    private double calculateBeverageDiscount(Order order) {

        double sum = 0.0;

        for (OrderItem o : order.getItems()) {
            if (o.getItem().isBeverage()) {
                sum += o.getSubtotal() * 0.20;
            }
        }

        return sum;

    }

    private void validateQuantity(int quantity) {

        if (quantity <= 0) {
            throw new InvalidQuantityException(quantity);
        }

    }

    private void validateTable(int tableNumber) {

        if (tableNumber < 1 || tableNumber > 50) {
            throw new InvalidTableException(tableNumber);
        }

    }
}
