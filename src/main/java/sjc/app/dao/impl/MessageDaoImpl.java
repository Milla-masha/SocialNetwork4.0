package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.MessageEntityImpl;
import sjc.app.dao.MessageDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MessageDaoImpl  extends GenericDaoImpl<MessageEntityImpl> implements MessageDao
{
    public MessageDaoImpl()
    {
        super(MessageEntityImpl.class);
    }

    @Override
    public List<MessageEntityImpl> getMessageByDialog(Long dialogId, int offset, int limit)
    {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MessageEntityImpl> query = criteriaBuilder.createQuery(MessageEntityImpl.class);
        Root<MessageEntityImpl> post = query.from(MessageEntityImpl.class);
        Predicate condition = criteriaBuilder.equal(post.get("dialog"), dialogId);
        query.orderBy(criteriaBuilder.desc(post.get("date")));
        query.where(condition);
        TypedQuery<MessageEntityImpl> resultQuery = getEntityManager().createQuery(query);
        resultQuery.setFirstResult(offset);
        resultQuery.setMaxResults(limit);
        return resultQuery.getResultList();
    }


    @Override
    public MessageEntityImpl getLastMessageByDialog(Long dialogId)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MessageEntityImpl> c = cb.createQuery(MessageEntityImpl.class);
        Root<MessageEntityImpl> post = c.from(MessageEntityImpl.class);
        Predicate condition = cb.equal(post.get("dialog"), dialogId);
        c.orderBy(cb.desc(post.get("date")));
        c.where(condition);
       /* TypedQuery<MessageEntityImpl> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);*/
        return getEntityManager().createQuery(c).setMaxResults(1).getSingleResult();
    }

    @Override
    public Long getCountMessagesByDialog(Long dialogId)
    {
        CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<MessageEntityImpl> post = cq.from(MessageEntityImpl.class);
        Predicate condition = qb.equal(post.get("dialog"), dialogId);
        cq.where(condition);
        cq.select(qb.count(post));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
