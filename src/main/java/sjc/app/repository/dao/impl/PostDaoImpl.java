package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.PostUserEntityImpl;
import sjc.app.model.entity.PostEntityImpl;
import sjc.app.repository.dao.PostDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PostDaoImpl extends GenericDaoImpl<PostEntityImpl> implements PostDao
{
    public PostDaoImpl() {
        super(PostEntityImpl.class);
    }

    @Override
    public List<PostUserEntityImpl> getPostsUser(Long idUser, int offset, int limit) {
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
