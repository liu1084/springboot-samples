package com.jim.mongodb.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jim.mongodb.config.EnumResponseStatus;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


/**
 * * API调用的返回类
 */
@JsonInclude(NON_NULL)
public class APIResponseDTO {
	private Object result;
	private String time;
	private Long code;
	private String message;

	public static APIResponseDTO toOkResponse(final Object data, final String message) {
		return toAPIResponseDTO(data, EnumResponseStatus.OK.getCode(), message);
	}

	public static APIResponseDTO toEmptyResponse(final Object data, final String message) {
		return toAPIResponseDTO(data, EnumResponseStatus.EMPTY.getCode(), message);
	}

	public static APIResponseDTO toErrorResponse(final Object data, final String message) {
		return toAPIResponseDTO(data, EnumResponseStatus.ERROR.getCode(), message);
	}

	public static APIResponseDTO toUnknownResponse(final Object data, final String message) {
		return toAPIResponseDTO(data, EnumResponseStatus.UNKNOWN.getCode(), message);
	}

	public static APIResponseDTO toExceptionResponse(final Object data, final String message) {
		return toAPIResponseDTO(data, EnumResponseStatus.EXCEPTION.getCode(), message);
	}

	private static APIResponseDTO toAPIResponseDTO(final Object data, final long code, final String mesage) {
		final APIResponseDTO response = new APIResponseDTO();
		response.setResult(data);
		response.setCode(code);
		response.setMessage(mesage);
		return response;
	}

	public void setCode(final Long code) {
		this.code = code;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(final Object result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String time) {
		this.time = time;
	}

	public long getCode() {
		return code;
	}

	public void setCode(final long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
