package sjc.app.rest.response.impl;

import org.apache.commons.collections.map.HashedMap;
import sjc.app.rest.response.PaginationResponseSuccessful;

import java.util.Map;

public class PaginationResponseImpl extends ResponseImpl implements PaginationResponseSuccessful
{
    Map<String,String> metadata=new HashedMap();


    @Override
    public void addMetadata(String key, String value)
    {
        metadata.put(key, value);
    }

    @Override
    public Map<String, String> getMetadata()
    {
        return metadata;
    }
}
