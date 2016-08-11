package sjc.app.rest.response;

import java.util.Map;

public interface PaginationResponseOk extends ResponseOk
{
    void addMetadata(String key, String value);

    Map<String,String> getMetadata();

}
