package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.Group;
import sjc.app.repository.dao.GroupDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao {
    @Override
    public List<Group> getGroupsUser(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Group> c = cb.createQuery(Group.class);
        Root<Group> groups = c.from(Group.class);
        Predicate condition = cb.equal(groups.get("users"), idUser);
        c.where(condition);
        TypedQuery<Group> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
}
