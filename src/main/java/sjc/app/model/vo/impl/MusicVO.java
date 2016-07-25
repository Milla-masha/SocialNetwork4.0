package sjc.app.model.vo.impl;

import sjc.app.model.vo.IMusic;

import java.sql.Time;

public class MusicVO implements IMusic
{

    private String name;
    private Time time;
    private String url;

    public MusicVO() {
    }

    public MusicVO(String url, String name, Time time) {
        this.url = url;
        this.name = name;
        this.time = time;
    }

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

}
