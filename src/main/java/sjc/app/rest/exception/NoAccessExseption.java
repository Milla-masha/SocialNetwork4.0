package sjc.app.rest.exception;

import sjc.app.constant.Constant;
import sjc.app.rest.response.ResponseException;

public class NoAccessExseption extends Exception implements ResponseException
{
    private String error= Constant.ERROR_NO_ACCESS;
    private String message;

    public NoAccessExseption()
    {
        super();
    }

    public NoAccessExseption(String message)
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
