package org.cuentas.exceptions;

public class Message {
    private String error;
    private String detail;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void buildMessage(String message){
        String[] items = message.split("Detail: ");
        setError(items[0].split("ERROR: ")[1]);
        setDetail(items[1]);
    }
}
