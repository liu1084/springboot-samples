package com.jim.data.service.impl;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:51
 * Description:
 */

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import com.jim.data.model.service.IPMSException;
import com.jim.data.model.service.IPMSStatus;

@Data
public class PMSException extends RuntimeException implements IPMSException {
    private Integer code;

    private String message;

    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private Gson gson;

    public PMSException(IPMSStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public PMSException(IPMSStatus status, String message) {
        this.code = status.getCode();
        this.message = status.getMessage() + "Cause by: " + message;
    }

    public PMSException(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public PMSException(Integer code, Errors errors) {
        this.code = code;
        this.message = gson.toJson(errors.getAllErrors());
    }

    public PMSException(IPMSStatus status, Errors errors) {
    }
}