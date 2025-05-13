package Splitwise.Groups;

import Splitwise.Groups.Group;

import java.util.List;

public class GroupsController {

    private List<Group> allGroups;


    public List<Group> getAllGroups() {
        return this.allGroups;
    }

    public void addGroup(Group group) {
        this.allGroups.add(group);
    }
}
