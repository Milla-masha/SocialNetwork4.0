package sjc.app.rest.response.impl;

import sjc.app.rest.response.ResponseOk;

public class ResponseImpl implements ResponseOk
{
    private Object entity=null;

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
