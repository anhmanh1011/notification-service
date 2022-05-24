package com.kss.notificationservice.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum EnumCodeResponse implements IResponseCode {

    INTERNAL_SERVER(500, "Internal Server Error"),
    UNAUTHORIZED(401, "UNAUTHORIAZOR"),
    NOT_FOUND(404, "NOT_FOUND"),
    PASSWORD_INVALID(6000, "Password is invalid"),
    INVALID_PARAM(6001, "Param is invalid"),
    USER_INFO_INVALID(6002, "User info invalid"),
    USER_NOT_FOUND(6003, "User not found"),
    OTP_INVALID(6004, "OTP is invalid"),
    OLD_PASSWORD_EQ_NEW_PASSWORD(6005, "new password must be diff old password"),
    OTP_MAX_RETRY_COUNT(6006, "OTP was max  times retry "),
    VERIFY_PASSWORD_MAX_RETRY_COUNT(6007, " feature verify password was max  times retry "),
    CHECK_PIN_INVALID(6008, "pin is invalid"),
    NEW_PIN_INVALID(6009, "New Pin must be diff old pin"),
    USER_SALE_EXISTS(6060, "user sale existed"),
    LEAST_1_RECORD(6011, "should have at least 1 record"),
    SALE_NOT_FOUND(6012, "sale not found");

    public final int code;
    public final String message;

    EnumCodeResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
