package sjc.app.model.vo;

import sjc.app.model.vo.impl.RegisterUserVO;

public interface IAuthorities
{
    long getId();

    void setId(long id);

    String getAuthorities();

    void setAuthorities(String authorities);

    RegisterUserVO getIdU();

    void setIdU(RegisterUserVO idU);
}
