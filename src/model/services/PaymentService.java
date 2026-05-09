package model.services;

import model.entities.Order;
import model.enums.OrderStatus;
import model.enums.PaymentMethod;
import model.exceptions.OrderAlreadyPaidException;

public class PaymentService {

    private void validatePayment(Order order) {

        if (order.isPaid()) {
            throw new OrderAlreadyPaidException();
        }

    }

    private void updateStatus(Order order) {

        if (order.isPending()) {
            order.setStatus(OrderStatus.PAID);
        }

    }

}
