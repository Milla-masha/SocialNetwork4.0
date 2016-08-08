package sjc.app.repository.dao.impl;


import org.springframework.stereotype.Repository;
import sjc.app.model.entity.GroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.GroupDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<GroupEntityImpl> implements GroupDao
{

    public GroupDaoImpl()
    {
        super(GroupEntityImpl.class);
    }

    @Override
    public List<GroupEntityImpl> getGroupsUser(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GroupEntityImpl> c = cb.createQuery(GroupEntityImpl.class);
        Root<UserEntityImpl> rUser = c.from(UserEntityImpl.class);
        Join<UserEntityImpl, GroupEntityImpl> joinAnswerCollaborator = rUser.join("groups");
        c.select(joinAnswerCollaborator).where(
                cb.equal(rUser.get("id"), idUser)
        );
        return getEntityManager().createQuery(c).setFirstResult(offset).setMaxResults(limit).getResultList();
    }
}
