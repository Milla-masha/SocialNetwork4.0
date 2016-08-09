package sjc.app.model.vo;

public class PostSmallVO
{
    Long fkImage;
    Long idTo;
    String text;

    public PostSmallVO()
    {
    }

    public Long getFkImage()
    {
        return fkImage;
    }

    public void setFkImage(Long fkImage)
    {
        this.fkImage = fkImage;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Long getIdTo()
    {
        return idTo;
    }

    public void setIdTo(Long idTo)
    {
        this.idTo = idTo;
    }
}
