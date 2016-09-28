package exception;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String s) {
        super(s);
    }
}
