package model.exceptions;

public class InvalidTableException extends RuntimeException {

    public InvalidTableException(int table) {
        super("Mesa inválida: " + table + ". Deve estar entre 1 a 50.");
    }

}
