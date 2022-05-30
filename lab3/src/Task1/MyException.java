package Task1;

import java.util.List;

public class MyException extends RuntimeException{
    HttpCode httpCode;

    public MyException(final String message) {
        super(message);
    }

    public MyException(final List<String> message, final HttpCode httpCode) {
        super(message.toString());
        this.httpCode = httpCode;
    }

    public HttpCode getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(final HttpCode httpCode) {
        this.httpCode = httpCode;
    }
}
