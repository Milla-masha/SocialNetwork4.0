package sjc.app.model.vo;


public class VideoFullVO extends BaseVO
{

    private String name;
    private String url;
    private String preView;
    private String description;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getPreView()
    {
        return preView;
    }

    public void setPreView(String preView)
    {
        this.preView = preView;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
