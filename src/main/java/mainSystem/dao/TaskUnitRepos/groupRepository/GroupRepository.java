package mainSystem.dao.TaskUnitRepos.groupRepository;

import mainSystem.model.userInitModels.Group;

public interface GroupRepository {
    Group getGroupById(int groupId);
}
