package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.InfoUser;
import sjc.app.model.entity.UserEntity;
import sjc.app.repository.dao.BlackListDao;
import sjc.app.repository.dao.FriendDao;
import sjc.app.repository.dao.InfoUserDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InfoUserDaoImpl extends GenericDaoImpl<InfoUser> implements InfoUserDao, BlackListDao, FriendDao {

    public InfoUserDaoImpl() {
        super(InfoUser.class);
    }

    @Override
    public List<InfoUser> getFriends(Long idUser, int offset, int limit) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<InfoUser> c = cb.createQuery(InfoUser.class);
        Root<InfoUser> users = c.from(InfoUser.class);
        Predicate condition = cb.equal(users.get("user"), idUser);
        c.where(condition);
        TypedQuery<InfoUser> q = getEntityManager().createQuery(c);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<InfoUser> getBlackList(Long idUser, int offset, int limit) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntity> cUser = cb.createQuery(UserEntity.class);
        Root<UserEntity> rUser = cUser.from(UserEntity.class);
        Predicate condition = cb.equal(rUser.get("id"), idUser);
        Join<UserEntity, UserEntity> joinAnswerCollaborator = rUser.join("blackListUsers");
        cUser.select(joinAnswerCollaborator).where(condition);
        TypedQuery<UserEntity> q = getEntityManager().createQuery(cUser);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<InfoUser> infoUsers = new ArrayList<>();
        List<UserEntity> userEntities = q.getResultList();
        for (UserEntity user : userEntities) {
            infoUsers.add(user.getInfoUser());
        }
        return infoUsers;
    }

    @Override
    public void addBlackList(Long ownerId, Long blackUserId) {
        try {
            UserEntity owner = getEntityManager().find(UserEntity.class, ownerId);
            UserEntity black = getEntityManager().find(UserEntity.class, blackUserId);
            List<UserEntity> blackList = owner.getBlackListUsers();
            for (UserEntity user : blackList) {
                if (user.getId().equals(black.getId())) {
                    return;
                }
            }
            owner.getBlackListUsers().add(black);
            getEntityManager().merge(owner);
        } catch (NullPointerException ne) {
        }
    }

    @Override
    public void deleteBlackList(Long ownerId, Long blackUserId) {
        try {
            UserEntity owner = getEntityManager().find(UserEntity.class, ownerId);
            UserEntity black = getEntityManager().find(UserEntity.class, blackUserId);
            List<UserEntity> blackList = owner.getBlackListUsers();
            int count = 0;
            for (UserEntity user : blackList) {
                if (user.getId().equals(black.getId())) {
                    owner.getBlackListUsers().remove(black);
                    getEntityManager().merge(owner);
                }
            }
        } catch (NullPointerException ne) {
        }
    }
}
