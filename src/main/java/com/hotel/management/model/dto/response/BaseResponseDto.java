package com.hotel.management.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.hotel.management.model.enums.StatusCode;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponseDto<T> {
    private T data;
    private StatusCode status;
    private Boolean isCancel;

    public BaseResponseDto(T data) {
        this.data = data;
        this.status = StatusCode.SUCCESS;
    }

    public BaseResponseDto(T data ,StatusCode status) {
        this.data = data;
        this.status = status;
    }

    public BaseResponseDto(Boolean isCancel) {
        this.data = null;
        this.status =  StatusCode.SUCCESS;
        this.isCancel = isCancel;
    }
}
