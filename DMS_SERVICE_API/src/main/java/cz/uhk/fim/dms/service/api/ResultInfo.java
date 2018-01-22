package cz.uhk.fim.dms.service.api;

public class ResultInfo<T> {

    public enum Status{
        SUCCESS,
        ERROR
    }

    private T object;
    private String message;
    private Status status;

    public ResultInfo() {
    }

    public ResultInfo(T object, String message, Status status) {
        this.object = object;
        this.message = message;
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
