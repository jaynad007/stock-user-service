package com.trading.userservice.models;


import java.util.List;

public class ErrorObject {

    private String errorCode;
    private List<String> errorMessage;

    public ErrorObject() {
    }

    public ErrorObject(String errorCode, List<String> errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;


    }
}
