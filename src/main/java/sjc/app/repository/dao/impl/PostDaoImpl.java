package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.PostUserEntityImpl;
import sjc.app.repository.dao.PostDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostDaoImpl extends GenericDaoImpl<PostUserEntityImpl> implements PostDao
{
    public PostDaoImpl()
    {
        super(PostUserEntityImpl.class);
    }

    @Override
    public List<PostUserEntityImpl> getPostsUser(Long idUser, int offset, int limit)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PostUserEntityImpl> c = cb.createQuery(PostUserEntityImpl.class);
        Root<PostUserEntityImpl> post = c.from(PostUserEntityImpl.class);
        Predicate condition = cb.equal(post.get("user"), idUser);
        c.where(condition);
        TypedQuery<PostUserEntityImpl> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
