package sjc.app.service.impl;

import org.springframework.stereotype.Service;
import sjc.app.repository.vo.IGroup;
import sjc.app.repository.vo.impl.GroupVO;
import sjc.app.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Override
    public List<IGroup> getGroups(Long userId, int offset, int limit) {
        List<IGroup> groups= new ArrayList<>();
        for (int i=0;i<5;i++) {
            IGroup group = new GroupVO();
            group.setName("VineVideo");
            group.setFolowers(512);
            group.setImage("https://pp.vk.me/c625318/v625318757/31e29/w019VKeY88g.jpg");
            groups.add(group);
        }
        return groups;
    }
}
