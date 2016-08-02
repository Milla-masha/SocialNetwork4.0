package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.Music;
import sjc.app.model.entity.Post;
import sjc.app.model.entity.UserEntity;
import sjc.app.repository.dao.PostDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PostDaoImpl extends GenericDaoImpl<Post> implements PostDao
{
    public PostDaoImpl() {
        super(Post.class);
    }

    @Override
    public List<Post> getPostsUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Post> cPost = cb.createQuery(Post.class);
        Root<UserEntity> rUser = cPost.from(UserEntity.class);
        Predicate condition = cb.equal(rUser.get("id"), idUser);
        Join<UserEntity,Post> joinAnswerCollaborator = rUser.join("posts");
        cPost.select(joinAnswerCollaborator).where(condition);
        TypedQuery<Post> q = getEntityManager().createQuery(cPost);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
