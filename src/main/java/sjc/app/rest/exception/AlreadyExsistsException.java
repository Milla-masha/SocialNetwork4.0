package sjc.app.rest.exception;

import sjc.app.constant.Constant;
import sjc.app.rest.response.ResponseException;

public class AlreadyExsistsException extends Exception implements ResponseException
{
    private String error = Constant.ERROR_DATA_CONFLICT;
    private String message;

    public AlreadyExsistsException()
    {
        super();
    }

    public AlreadyExsistsException(String message)
    {
        super(message);
        this.message = message;
    }

    @Override
    public String getError()
    {
        return error;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
