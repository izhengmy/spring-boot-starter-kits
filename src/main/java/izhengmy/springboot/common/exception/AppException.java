package izhengmy.springboot.common.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AppException extends RuntimeException {

    private final int code;

    private Map<String, Object> data = new HashMap<>();

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(int code, String message, Map<String, Object> data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public AppException(String message) {
        this(0, message);
    }

    public AppException(String message, Map<String, Object> data) {
        this(0, message, data);
    }

    public AppException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public AppException(ErrorCode errorCode, Map<String, Object> data) {
        this(errorCode.getCode(), errorCode.getMessage(), data);
    }

    public AppException addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public static AppException validationFailed(String key, Object value) {
        return new AppException(CommonErrorCode.UNPROCESSABLE_ENTITY).addData(key, value);
    }

    public static AppException validationFailed(Map<String, Object> data) {
        return new AppException(CommonErrorCode.UNPROCESSABLE_ENTITY, data);
    }

}
