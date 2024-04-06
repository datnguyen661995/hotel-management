package com.hotel.management.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.hotel.management.model.enums.StatusCode;

@AllArgsConstructor
@Data
public class BaseResponseDto<T> {
    private T data;
    private StatusCode status;
    private Boolean isStatus;

    public BaseResponseDto(T data) {
        this.data = data;
        this.status = StatusCode.SUCCESS;
    }

    public BaseResponseDto(T data ,StatusCode status) {
        this.data = data;
        this.status = status;
    }

    public BaseResponseDto(Boolean isStatus) {
        this.data = null;
        this.isStatus = isStatus;
        this.status =  StatusCode.SUCCESS;
    }
}
