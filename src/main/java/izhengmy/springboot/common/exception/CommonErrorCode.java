package izhengmy.springboot.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonErrorCode implements ErrorCode {

    UNPROCESSABLE_ENTITY(422, "请求参数错误"),
    INTERNAL_SERVER_ERROR(500, "服务器错误");

    private final int code;

    private final String message;

}
