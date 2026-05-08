package model.services;

import model.entities.Order;
import model.entities.OrderItem;
import model.exceptions.InvalidQuantityException;
import model.exceptions.InvalidTableException;

import java.time.LocalTime;

public class OrderService {

    private boolean isHappyHour(LocalTime time){

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
