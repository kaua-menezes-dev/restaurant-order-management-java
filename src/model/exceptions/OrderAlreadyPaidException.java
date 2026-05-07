package model.exceptions;

public class OrderAlreadyPaidException extends RuntimeException {

    public OrderAlreadyPaidException() {
        super("Pedido já foi pago.");
    }

}
