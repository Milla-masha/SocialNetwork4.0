package sjc.app.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.dao.PostUserDao;
import sjc.app.model.entity.PostUserEntityImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostUserDaoImpl extends GenericDaoImpl<PostUserEntityImpl> implements PostUserDao
{
    public PostUserDaoImpl()
    {
        super(PostUserEntityImpl.class);
    }

    @Override
    public List<PostUserEntityImpl> getPostsUser(Long idUser, int offset, int limit)
    {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PostUserEntityImpl> criteriaQuery = builder.createQuery(PostUserEntityImpl.class);
        Root<PostUserEntityImpl> postRoot = criteriaQuery.from(PostUserEntityImpl.class);
        Predicate condition = builder.equal(postRoot.get("user"), idUser);
        criteriaQuery.where(condition);
        criteriaQuery.orderBy(builder.desc(postRoot.get("date")));
        TypedQuery<PostUserEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountPostsUser(Long idUser)
    {
        CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<PostUserEntityImpl> post = cq.from(PostUserEntityImpl.class);
        Predicate condition = qb.equal(post.get("user"), idUser);
        cq.where(condition);
        cq.select(qb.count(post));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
