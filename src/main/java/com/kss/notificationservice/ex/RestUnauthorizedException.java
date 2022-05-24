package com.kss.notificationservice.ex;

import com.kss.notificationservice.model.common.EnumCodeResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestUnauthorizedException extends Exception {
    int errorCode;
    String message;
    public RestUnauthorizedException() {
        this.message = EnumCodeResponse.UNAUTHORIZED.getMessage();
        this.errorCode = EnumCodeResponse.UNAUTHORIZED.getCode();
    }

}
