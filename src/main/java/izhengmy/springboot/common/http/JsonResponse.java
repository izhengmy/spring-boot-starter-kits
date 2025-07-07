package izhengmy.springboot.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record JsonResponse<T>(int code, String message, T data, Map<String, Object> errors) {

    public static JsonResponse<Map<String, Object>> success() {
        return success(new HashMap<>());
    }

    public static <T> JsonResponse<T> success(T data) {
        return new JsonResponse<>(200, "success", data, null);
    }

    public static JsonResponse<?> error(int code, String message) {
        return error(code, message, new HashMap<>());
    }

    public static JsonResponse<?> error(int code, String message, Map<String, Object> errors) {
        return new JsonResponse<>(code, message, null, errors);
    }

}
