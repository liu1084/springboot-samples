package com.jim.data.model.domain;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:49
 * Description:
 */

import com.github.pagehelper.PageInfo;
import com.jim.data.model.service.IPMSException;
import com.jim.data.model.service.IPMSStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ApiModel
@NoArgsConstructor
@ToString
public class APIResponse<T> implements Serializable {
    @ApiModelProperty(name = "返回是否成功")
    private Boolean success;

    @ApiModelProperty(name = "返回失败后的错误码")
    private Integer errorCode;

    @ApiModelProperty(name = "返回失败后的错误信息")
    private String errorMsg;

    @ApiModelProperty(name = "返回成功后的分页对象")
    private Pagination pagination;

    @ApiModelProperty(name = "返回成功后的对象")
    private T result;

    public static APIResponse success() {
        APIResponse APIResponse = new APIResponse();
        APIResponse.setSuccess(Boolean.TRUE);
        return APIResponse;
    }

    public static <T> APIResponse<T> success(T result) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.TRUE);
        APIResponse.setResult(result);
        return APIResponse;
    }

    public static <T> APIResponse<T> success(G2Page page) {
        APIResponse APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.TRUE);
        if (page != null) {
            APIResponse.setResult(page.getList());
            APIResponse.setPagination(new Pagination(page.getPageSize(), page.getCurrent(), page.getTotal(), page.getTotalPageNum()));
        }
        return APIResponse;
    }

    public static <T> APIResponse<T> success(PageInfo page) {
        APIResponse APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.TRUE);
        if (page != null) {
            APIResponse.setResult(page.getList());
            APIResponse.setPagination(new Pagination(page.getPageSize(), page.getPageNum(), page.getTotal(), page.getPages()));
        }
        return APIResponse;
    }

    public static <T> APIResponse<T> success(T result, Pagination pagination) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.TRUE);
        APIResponse.setResult(result);
        APIResponse.setPagination(pagination);
        return APIResponse;
    }

    public static <T> APIResponse<T> error(Errors errors) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.FALSE);
        APIResponse.setErrorCode(-1);
        List<ObjectError> allErrors = errors.getAllErrors();
        APIResponse.setErrorMsg(allErrors.stream().map(Object::toString).collect(Collectors.joining(",")));
        return APIResponse;
    }

    public static <T> APIResponse<T> error(IPMSStatus status) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.FALSE);
        APIResponse.setErrorCode(status.getCode());
        APIResponse.setErrorMsg(status.getMessage());
        return APIResponse;
    }

    public static <T> APIResponse<T> error(IPMSStatus status, String errorMsg) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.FALSE);
        APIResponse.setErrorCode(status.getCode());
        APIResponse.setErrorMsg(errorMsg);
        return APIResponse;
    }

    public static <T> APIResponse<T> error(int code, String errorMsg) {
        APIResponse<T> apiResponse = new APIResponse<>();
        apiResponse.setSuccess(Boolean.FALSE);
        apiResponse.setErrorCode(code);
        apiResponse.setErrorMsg(errorMsg);
        return apiResponse;
    }

    public static <T> APIResponse<T> error(IPMSException e) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.FALSE);
        if (e != null) {
            APIResponse.setErrorCode(e.getCode());
            APIResponse.setErrorMsg(e.getMessage());
        }
        return APIResponse;
    }

    public static <T> APIResponse<T> error(IPMSException e, String errorMsg) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(Boolean.FALSE);
        if (e != null) {
            APIResponse.setErrorCode(e.getCode());
        }
        if (!StringUtils.isBlank(errorMsg)) {
            APIResponse.setErrorMsg(errorMsg);
        }
        return APIResponse;
    }

    public static <T> APIResponse<T> valueOf(Boolean result) {
        APIResponse<T> APIResponse = new APIResponse<>();
        APIResponse.setSuccess(result);
        return APIResponse;
    }
}