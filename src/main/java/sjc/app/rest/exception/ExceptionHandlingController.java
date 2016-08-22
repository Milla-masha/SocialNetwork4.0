package sjc.app.rest.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.TransactionRequiredException;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlingController
{
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "databaseError!!!!1" )
    @ExceptionHandler({SQLException.class,TransactionRequiredException.class, ConstraintViolationException.class})
    @ResponseBody
    public String databaseError() {
        return "You could not adding data.";
    }
}
