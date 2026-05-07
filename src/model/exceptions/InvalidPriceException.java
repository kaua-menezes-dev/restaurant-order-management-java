package model.exceptions;

public class InvalidPriceException extends RuntimeException {

    public InvalidPriceException(Double price) {
        super("Preço inválido: " + price +". Deve ser maior que zero.");
    }

}
