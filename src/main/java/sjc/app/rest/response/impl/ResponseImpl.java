package sjc.app.rest.response.impl;

import sjc.app.rest.response.ResponseSuccessful;

public class ResponseImpl implements ResponseSuccessful
{
    private Object entity = null;

    @Override
    public void setEntity(Object entity)
    {
        this.entity = entity;
    }

    @Override
    public Object getEntity()
    {
        return entity;
    }
}
