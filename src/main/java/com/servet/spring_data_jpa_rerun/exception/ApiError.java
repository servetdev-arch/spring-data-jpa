package com.servet.spring_data_jpa_rerun.exception;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ApiError<T>  {

    private String id;

    private Date errorTime;

    private T errors;

    public ApiError() {
    }

    public ApiError(String id, Date errorTime, T errors) {
        this.id = id;
        this.errorTime = errorTime;
        this.errors = errors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }
}
