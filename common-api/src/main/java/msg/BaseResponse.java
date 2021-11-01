package msg;

public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public String getCode() {
        return code;
    }

    public BaseResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
