package sjc.app.rest.exception;

import sjc.app.constant.Constant;
import sjc.app.rest.response.ResponseException;

public class NotFoundExseption extends Exception implements ResponseException
{
    private String error = Constant.ERROR_DATA_NOT_FOUND;
    private String message;

    public NotFoundExseption()
    {
        super();
    }

    public NotFoundExseption(String message)
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
