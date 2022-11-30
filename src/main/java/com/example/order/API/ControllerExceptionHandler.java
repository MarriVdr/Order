package com.example.order.API;

import com.example.order.exceptions.FieldIsEmptyException;
import com.example.order.exceptions.IdDoesNotExistsException;
import com.example.order.exceptions.ItemAlreadyExistsException;
import com.example.order.exceptions.MemberAlreadyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler({FieldIsEmptyException.class, IdDoesNotExistsException.class,ItemAlreadyExistsException.class, MemberAlreadyExistException.class})
    protected void bookExceptionHandler(RuntimeException ex, HttpServletResponse response) throws IOException {
        logger.warn(ex.getMessage());
        ex.printStackTrace();
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }
}
