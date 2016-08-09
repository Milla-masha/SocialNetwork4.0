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
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PostGroupEntityImpl> c = cb.createQuery(PostGroupEntityImpl.class);
        Root<PostGroupEntityImpl> post = c.from(PostGroupEntityImpl.class);
        Predicate condition = cb.equal(post.get("Group"), idGroup);
        c.where(condition);
        TypedQuery<PostGroupEntityImpl> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
