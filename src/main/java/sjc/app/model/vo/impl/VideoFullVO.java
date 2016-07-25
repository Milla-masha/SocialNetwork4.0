package sjc.app.model.vo.impl;


import sjc.app.model.vo.IVideoFull;

public class VideoFullVO implements IVideoFull
{

    String name;
    String url;
    String preView;
    String description;

    public VideoFullVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreView() {
        return preView;
    }

    public void setPreView(String preView) {
        this.preView = preView;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
