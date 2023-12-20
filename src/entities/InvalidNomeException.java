package entities;

//ClasseExceção 2
public class InvalidNomeException extends Exception {
    public InvalidNomeException(String message) {
        super(message);
    }
}