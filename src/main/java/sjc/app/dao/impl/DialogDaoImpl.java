package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.DialogEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.dao.DialogDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DialogDaoImpl extends GenericDaoImpl<DialogEntityImpl> implements DialogDao
{
    public DialogDaoImpl()
    {
        super(DialogEntityImpl.class);
    }

    @Override
    public List<DialogEntityImpl> getDialogsByUser(Long userId, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<DialogEntityImpl> criteriaQuery = cb.createQuery(DialogEntityImpl.class);
        Root<DialogEntityImpl> root = criteriaQuery.from(DialogEntityImpl.class);
        Join<UserEntityImpl, DialogEntityImpl> usersJoin = root.join("users");
        criteriaQuery.select(root).where(cb.equal(usersJoin.get("id"), userId));
        TypedQuery<DialogEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountDialogsByUser(Long userId)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DialogEntityImpl> root = cq.from(DialogEntityImpl.class);
        Join<UserEntityImpl, DialogEntityImpl> usersJoin = root.join("users");
        cq.select(cb.count(root)).where(cb.equal(usersJoin.get("id"), userId));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
