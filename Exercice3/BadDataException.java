package Exercice3;

import java.io.IOException;

public class BadDataException extends IOException {
    public BadDataException(String messageErr) {
        super(messageErr);
    }
}
