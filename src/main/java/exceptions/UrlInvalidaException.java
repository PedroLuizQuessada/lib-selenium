package exceptions;

public class UrlInvalidaException extends Exception {
    public UrlInvalidaException(String url) {
        super(String.format("URL %s inválida", url));
    }
}
