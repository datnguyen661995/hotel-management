package com.hotel.management.model.dto.response;

import com.hotel.management.model.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class BaseResponseDto<T> {
    private T data;
    private ResponseStatus status;

    public BaseResponseDto(T data) {
        this.data = data;
        this.status = ResponseStatus.SUCCESS;
    }
}
