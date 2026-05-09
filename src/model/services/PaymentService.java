package model.services;

import model.entities.Order;
import model.enums.OrderStatus;
import model.enums.PaymentMethod;
import model.exceptions.OrderAlreadyPaidException;

public class PaymentService {


    public void processPayment(Order order, PaymentMethod method) {

        validatePayment(order);

        OrderService orderService = new OrderService();
        orderService.calculateTotal(order);

        order.setPaymentMethod(method);

        updateStatus(order);

    }

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
