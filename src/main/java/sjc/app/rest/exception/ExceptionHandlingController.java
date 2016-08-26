package sjc.app.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sjc.app.rest.response.ResponseException;
import sjc.app.rest.response.impl.ResponseExseptionImpl;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

@ControllerAdvice
public class ExceptionHandlingController
{

    @ResponseStatus(value = HttpStatus.CONFLICT )
    @ExceptionHandler(AlreadyExsistsException.class)
    @ResponseBody
    public ResponseException databaseError(ResponseException ex) {
        ResponseException responseExseption=new ResponseExseptionImpl(ex.getError(),ex.getMessage());
        return responseExseption;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundExseption.class)
    @ResponseBody
    public ResponseException notFoundError(ResponseException ex) {
        ResponseException responseExseption=new ResponseExseptionImpl(ex.getError(),ex.getMessage());
        return responseExseption;
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(NoAccessExseption.class)
    @ResponseBody
    public ResponseException noAccessError(ResponseException ex) {
        ResponseException responseExseption=new ResponseExseptionImpl(ex.getError(),ex.getMessage());
        return responseExseption;
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseException nullPointerError(NullPointerException ex) {
        ResponseException responseExseption=new ResponseExseptionImpl(ex.toString(),ex.getLocalizedMessage());
        return responseExseption;
    }

    HttpStatus resolveAnnotatedResponseStatus(ResponseException exception) {
        ResponseStatus annotation = findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

