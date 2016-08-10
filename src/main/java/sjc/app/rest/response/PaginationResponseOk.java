package sjc.app.rest.response;

import sjc.app.rest.response.impl.Metadata;

public interface PaginationResponseOk extends ResponseOk
{
    void buildMetadata(Integer offset, Integer limit, Long count);

    Metadata getMetadata();

}
