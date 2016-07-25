package sjc.app.model.vo;

import java.sql.Time;

public interface IMusic
{
    String getUrl();

    void setUrl(String url);

    String getName();

    void setName(String name);

    Time getTime();

    void setTime(Time time);
}
