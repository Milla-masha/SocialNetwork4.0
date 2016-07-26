package sjc.app.service.impl;

import org.springframework.stereotype.Service;
import sjc.app.model.vo.GroupVO;
import sjc.app.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public List<GroupVO> getGroups(Long userId, int offset, int limit) {
        List<GroupVO> groups = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GroupVO group = new GroupVO();
            group.setName("VineVideo");
            group.setFolowers(512);
            group.setImage("https://pp.vk.me/c625318/v625318757/31e29/w019VKeY88g.jpg");
            groups.add(group);
        }
        return groups;
    }

    @Override
    public GroupVO getGroup(Long groupId) {
        GroupVO group=new GroupVO();
        group.setName("VineVideo");
        group.setFolowers(512);
        group.setImage("https://pp.vk.me/c625318/v625318757/31e29/w019VKeY88g.jpg");
        group.setDescription("ekjrgelrsgjenrgkernkgneang;negj;eng;lnaer;gn;aengwegn;erngk;");
        return group;
    }
}
