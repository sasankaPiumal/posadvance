package com.sasstack.posadvance.adviser;

import com.sasstack.posadvance.exception.DuplicateEntryException;
import com.sasstack.posadvance.exception.EntryNotFoundException;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<StandardResponse> handleClassNotFoundException(ClassNotFoundException exception) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, exception.getMessage(), exception), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponse> handleDuplicateEntryException(DuplicateEntryException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(409, e.getMessage(), e), HttpStatus.CONFLICT
        );
    }

}
