package model.exceptions;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException(int quantity) {
        super("Quantidade inválida: " + quantity + ". Deve ser maior que zero.");
    }

}
