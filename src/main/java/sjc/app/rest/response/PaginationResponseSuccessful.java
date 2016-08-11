package sjc.app.rest.response;

import java.util.Map;

public interface PaginationResponseSuccessful extends ResponseSuccessful
{
    void addMetadata(String key, String value);

    Map<String,String> getMetadata();

}
