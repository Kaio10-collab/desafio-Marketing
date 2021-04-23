package br.com.zup.Marketing.exceptions;

public class ErroCustomizado extends RuntimeException{

    private int statusCode;

    public ErroCustomizado(String message) {
        super(message);
    }

    public ErroCustomizado(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}