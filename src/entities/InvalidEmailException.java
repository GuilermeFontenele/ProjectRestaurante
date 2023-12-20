package entities;

//ClasseExceção 1
public class InvalidEmailException extends Exception{
    public InvalidEmailException(String message) {
        super(message);
    }
}
