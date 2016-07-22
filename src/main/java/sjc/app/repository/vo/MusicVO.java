package sjc.app.repository.vo;

import java.sql.Time;

public class MusicVO
{

    public MusicVO() {
    }

    public MusicVO(String url, String name, Time time) {
        this.url = url;
        this.name = name;
        this.time = time;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    private String name;

    private Time time;
}
