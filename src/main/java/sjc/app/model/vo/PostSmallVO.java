package sjc.app.model.vo;

public class PostSmallVO extends BaseVO
{
    private Long fkImage;
    private Long idTo;
    private String text;
    private String date;

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
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
