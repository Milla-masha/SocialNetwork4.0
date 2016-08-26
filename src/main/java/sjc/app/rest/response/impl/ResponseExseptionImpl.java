package sjc.app.rest.response.impl;

import org.springframework.stereotype.Service;
import sjc.app.rest.response.ResponseException;

@Service
public class ResponseExseptionImpl implements ResponseException
{
    private String error;
    private String message;

    public ResponseExseptionImpl()
    {
    }

    public ResponseExseptionImpl(String error, String message)
    {
        this.error = error;
        this.message = message;
    }

    @Override
    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
