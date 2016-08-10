package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.repository.dao.BlackListDao;
import sjc.app.repository.dao.FriendDao;
import sjc.app.repository.dao.UserDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntityImpl> implements UserDao, FriendDao, BlackListDao
{

    public UserDaoImpl()
    {
        super(UserEntityImpl.class);
    }

    @Override
    public UserEntityImpl findByName(String userName)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntityImpl> c = cb.createQuery(UserEntityImpl.class);
        Root<UserEntityImpl> registerUser = c.from(UserEntityImpl.class);
        Predicate condition = cb.equal(registerUser.get("login"), userName);
        c.where(condition);
        TypedQuery<UserEntityImpl> q = getEntityManager().createQuery(c);
        return q.getSingleResult();
    }

    @Override
    public List<UserEntityImpl> getFriends(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntityImpl> cUser = cb.createQuery(UserEntityImpl.class);
        Root<UserEntityImpl> rUser = cUser.from(UserEntityImpl.class);
        Predicate condition = cb.equal(rUser.get("id"), idUser);
        Join<UserEntityImpl, UserEntityImpl> joinAnswerCollaborator = rUser.join("friends");
        cUser.select(joinAnswerCollaborator).where(condition);
        TypedQuery<UserEntityImpl> q = getEntityManager().createQuery(cUser);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountFriends(Long userId)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cUser = cb.createQuery(Long.class);
        Root<UserEntityImpl> rUser = cUser.from(UserEntityImpl.class);
        Predicate condition = cb.equal(rUser.get("id"), userId);
        Join<UserEntityImpl, UserEntityImpl> joinAnswerCollaborator = rUser.join("friends");
        cUser.select(cb.count(joinAnswerCollaborator)).where(condition);
        return getEntityManager().createQuery(cUser).getSingleResult();
    }

    @Override
    public List<UserEntityImpl> getBlackList(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntityImpl> cUser = cb.createQuery(UserEntityImpl.class);
        Root<UserEntityImpl> rUser = cUser.from(UserEntityImpl.class);
        Predicate condition = cb.equal(rUser.get("id"), idUser);
        Join<UserEntityImpl, UserEntityImpl> joinAnswerCollaborator = rUser.join("blackListUsers");
        cUser.select(joinAnswerCollaborator).where(condition);
        TypedQuery<UserEntityImpl> q = getEntityManager().createQuery(cUser);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public void addBlackList(Long ownerId, Long blackUserId)
    {
        try
        {
            UserEntityImpl owner = getEntityManager().find(UserEntityImpl.class, ownerId);
            UserEntityImpl black = getEntityManager().find(UserEntityImpl.class, blackUserId);
            List<UserEntityImpl> blackList = owner.getBlackListUsers();
            for (UserEntityImpl user : blackList)
            {
                if (user.getId().equals(black.getId()))
                {
                    return;
                }
            }
            owner.getBlackListUsers().add(black);
            getEntityManager().merge(owner);
        } catch (NullPointerException ne)
        {
        }
    }

    @Override
    public void deleteBlackList(Long ownerId, Long blackUserId)
    {
        try
        {
            UserEntityImpl owner = getEntityManager().find(UserEntityImpl.class, ownerId);
            UserEntityImpl black = getEntityManager().find(UserEntityImpl.class, blackUserId);
            List<UserEntityImpl> blackList = owner.getBlackListUsers();
            for (UserEntityImpl user : blackList)
            {
                if (user.getId().equals(black.getId()))
                {
                    owner.getBlackListUsers().remove(black);
                    getEntityManager().merge(owner);
                }
            }
        } catch (NullPointerException ne)
        {
        }
    }

    @Override
    public Long getCountBlackList(Long idUser)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cUser = cb.createQuery(Long.class);
        Root<UserEntityImpl> rUser = cUser.from(UserEntityImpl.class);
        Predicate condition = cb.equal(rUser.get("id"), idUser);
        Join<UserEntityImpl, UserEntityImpl> joinAnswerCollaborator = rUser.join("blackListUsers");
        cUser.select(cb.count(joinAnswerCollaborator)).where(condition);
        return getEntityManager().createQuery(cUser).getSingleResult();
    }
}

