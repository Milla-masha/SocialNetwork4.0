package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.NotificationDao;
import sjc.app.model.entity.NotificationEntityImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class NotificationDaoImpl extends GenericDaoImpl<NotificationEntityImpl> implements NotificationDao
{
    public NotificationDaoImpl()
    {
        super(NotificationEntityImpl.class);
    }

    @Override
    public NotificationEntityImpl findByToken(String token)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NotificationEntityImpl> c = cb.createQuery(NotificationEntityImpl.class);
        Root<NotificationEntityImpl> notificationRoot = c.from(NotificationEntityImpl.class);
        Predicate condition = cb.equal(notificationRoot.get("token"), token);
        c.where(condition);
        TypedQuery<NotificationEntityImpl> q = getEntityManager().createQuery(c);
        return q.getSingleResult();
    }
}
