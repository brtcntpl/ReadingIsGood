package com.getir.readingisgood.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResponseWrapper", description = "Object model acting as a response wrapper")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper<T> {

    private T data;
    @ApiModelProperty(hidden = true)
    private ErrorWrapper error;
    private Boolean success;
    private int status;

    public ResponseWrapper(int status) {
        this.status = status;
        this.success = initSuccess(status);
    }

    public ResponseWrapper(T data, int status){
        this(status);
        this.data = data;
    }


    public ResponseWrapper(ErrorWrapper error, int status){
        this(status);
        this.error = error;
    }

    private boolean initSuccess(int status){
        return status >= 200 && status < 300;
    }
}