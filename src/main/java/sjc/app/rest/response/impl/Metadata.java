package sjc.app.rest.response.impl;

 public class Metadata
{
    public Metadata(Integer offset, Integer limit, Long count)
    {
        this.offset = offset;
        this.limit = limit;
        this.count = count;
    }

    private Integer offset;
    private Integer limit;
    private Long count;

    public Integer getOffset()
    {
        return offset;
    }

    public Integer getLimit()
    {
        return limit;
    }

    public Long getCount()
    {
        return count;
    }
}
