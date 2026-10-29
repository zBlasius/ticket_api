package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.AuthorNotFoundException;
import com.main.ticket_api.session_management.domain.RoomNameAlreadyExistsException;
import com.main.ticket_api.session_management.domain.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Translates domain exceptions into HTTP responses for this module's controllers
@RestControllerAdvice(basePackageClasses = SessionManagementExceptionHandler.class)
public class SessionManagementExceptionHandler {

    @ExceptionHandler({AuthorNotFoundException.class, RoomNotFoundException.class})
    public ProblemDetail handleNotFound(RuntimeException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(RoomNameAlreadyExistsException.class)
    public ProblemDetail handleRoomNameAlreadyExists(RoomNameAlreadyExistsException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
}
