package com.hatchways.assessment.rest.response;

public class ErrorResponse  extends Response{

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
