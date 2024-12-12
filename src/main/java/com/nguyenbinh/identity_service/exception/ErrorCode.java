package com.nguyenbinh.identity_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
public enum ErrorCode {

    USER_EXISTED ( 1001,  "User Exited!", HttpStatus.BAD_REQUEST ),
    INVALID_PASSWORD_LENGTH ( 1002, "Password Must Be Longer Than 8 Character!!!",HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_INVALID (1003, "Username Must Longer Than 3 Characters",HttpStatus.BAD_REQUEST),
    INVALID_EXCEPTION_KEY (1004, "Invalid Exception Key",HttpStatus.BAD_REQUEST),
    USERNAME_NOT_EXISTED (1005, "Username Not Existed!", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED_EXCEPTION (1006, "Unauthenticated Exception", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "YOU DO NOT HAS PERMISSION", HttpStatus.FORBIDDEN);
    ;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.statusCode= httpStatusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;


}
