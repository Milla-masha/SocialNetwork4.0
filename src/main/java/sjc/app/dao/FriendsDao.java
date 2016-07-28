package sjc.app.dao;

import sjc.app.model.entity.Friends;
import sjc.app.model.entity.InfoUser;

import java.util.List;

/**
 * Created by psycl on 27.07.2016.
 */
public interface FriendsDao extends GenericDao<Friends> {

    List<InfoUser> getFriends(Long idUser, int offset, int limit);
}
