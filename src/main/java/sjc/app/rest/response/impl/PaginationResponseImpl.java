package sjc.app.rest.response.impl;

import sjc.app.rest.response.PaginationResponseOk;

public class PaginationResponseImpl extends ResponseImpl implements PaginationResponseOk
{
    private Metadata metadata=null;

    @Override
    public void buildMetadata(Integer offset, Integer limit, Long count)
    {
        this.metadata = new Metadata(offset, limit, count);
    }

    @Override
    public Metadata getMetadata()
    {
        return metadata;
    }
}
