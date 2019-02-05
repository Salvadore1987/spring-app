package uz.salvadore.spring.app.models;

public class Response<T> {

    private Integer code;
    private String message;
    private T object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + "\"" + code + "\"" +
                ", \"message\":'" + "\"" + message + "\"" +
                ", \"object\":" + "\"" + object + "\"" +
                "}";
    }
}
