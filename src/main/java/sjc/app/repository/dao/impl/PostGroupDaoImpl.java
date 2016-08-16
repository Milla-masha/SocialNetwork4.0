package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.PostGroupEntityImpl;
import sjc.app.repository.dao.PostGroupDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostGroupDaoImpl extends GenericDaoImpl<PostGroupEntityImpl> implements PostGroupDao
{
    public PostGroupDaoImpl()
    {
        super(PostGroupEntityImpl.class);
    }

    @Override
    public List<PostGroupEntityImpl> getPostsGroup(Long idGroup, int offset, int limit)
    {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PostGroupEntityImpl> criteriaQuery = builder.createQuery(PostGroupEntityImpl.class);
        Root<PostGroupEntityImpl> postRoot = criteriaQuery.from(PostGroupEntityImpl.class);
        Predicate condition = builder.equal(postRoot.get("Group"), idGroup);
        criteriaQuery.where(condition);
        criteriaQuery.orderBy(builder.desc(postRoot.get("date")));
        TypedQuery<PostGroupEntityImpl> q = getEntityManager().createQuery(criteriaQuery);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public Long getCountPostsByGroup(Long groupId)
    {
        CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<PostGroupEntityImpl> post = cq.from(PostGroupEntityImpl.class);
        Predicate condition = qb.equal(post.get("group"), groupId);
        cq.where(condition);
        cq.select(qb.count(post));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
