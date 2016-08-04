package com.wavemaker.notification.exception.handler;

import com.wavemaker.notification.exception.AppException;
import com.wavemaker.notification.exception.DaoException;
import com.wavemaker.notification.exception.ErrorMessage;
import com.wavemaker.notification.exception.ManagerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tarund on 3/8/16.
 */
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(ManagerException ex) {
        ErrorMessage errorMessage = createErrorMessage(ex);
        return errorMessage;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    ErrorMessage handleException(DaoException ex) {
        ErrorMessage errorMessage = createErrorMessage(ex);
        return errorMessage;
    }

    private ErrorMessage createErrorMessage(AppException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        return  errorMessage;
    }
}
