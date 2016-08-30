package sjc.app.dao.impl;


import org.springframework.stereotype.Repository;
import sjc.app.model.entity.GroupEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.dao.GroupDao;

import javax.persistence.criteria.*;
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

    @Override
    public Long getCountGroups(Long userId)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GroupEntityImpl> root = cq.from(GroupEntityImpl.class);
        Join<UserEntityImpl, GroupEntityImpl> usersJoin = root.join("users");
        cq.select(cb.count(root)).where(cb.equal(usersJoin.get("id"), userId));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public List<GroupEntityImpl> findGroupsByName(String groupName, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GroupEntityImpl> c = cb.createQuery(GroupEntityImpl.class);
        Root<GroupEntityImpl> groupEntityRoot = c.from(GroupEntityImpl.class);
        Predicate condition = cb.like(groupEntityRoot.get("name"), "%" + groupName + "%");
        c.where(condition);
        return  getEntityManager().createQuery(c).setFirstResult(offset).setMaxResults(limit).getResultList();

    }
}