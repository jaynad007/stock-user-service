package com.trading.userservice.Exception;

import com.trading.userservice.models.ErrorObject;

public class UserServiceException extends Exception{

    private ErrorObject error;

    public UserServiceException(ErrorObject error) {
        this.error = error;
    }

    public UserServiceException(String message, ErrorObject error) {
        super(message);
        this.error = error;
    }

    public UserServiceException(Throwable cause, ErrorObject error) {
        super(cause);
        this.error = error;
    }

    public UserServiceException(String message, Throwable cause, ErrorObject error) {
        super(message, cause);
        this.error = error;
    }

    public UserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorObject error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
