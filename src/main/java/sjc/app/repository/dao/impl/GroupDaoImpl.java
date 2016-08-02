package sjc.app.repository.dao.impl;


import org.springframework.stereotype.Repository;
import sjc.app.model.entity.Group;
import sjc.app.model.entity.UserEntity;
import sjc.app.repository.dao.GroupDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao {

    public GroupDaoImpl() {
        super(Group.class);
    }

    @Override
    public List<Group> getGroupsUser(Long idUser, int offset, int limit) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Group> c = cb.createQuery(Group.class);
        Root<UserEntity> rUser = c.from(UserEntity.class);
        Join<UserEntity,Group> joinAnswerCollaborator = rUser.join("groups");
        c.select(joinAnswerCollaborator).where(
                cb.equal(rUser.get("id"), idUser)
        );
        return getEntityManager().createQuery(c).setFirstResult(offset).setMaxResults(limit).getResultList();
    }
}
