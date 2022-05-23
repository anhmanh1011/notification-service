package com.kss.notificationservice.ex;

import com.kss.notificationservice.model.IResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends Exception {
    int errorCode;
    String message;

    public ApiException(int code, String message) {
        this.message = message;
        this.errorCode = code;
    }

    public ApiException(IResponseCode enumCodeResponse) {
        this.errorCode = enumCodeResponse.getCode();
        this.message = enumCodeResponse.getMessage();
    }
}
