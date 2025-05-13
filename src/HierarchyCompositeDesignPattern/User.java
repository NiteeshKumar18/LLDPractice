package HierarchyCompositeDesignPattern;

public class User implements Hierarchy {
    private final String userId;

    private final String name;

    private final String managerId;

    public User(String userId, String name, String managerId) {
        this.userId = userId;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    public void print() {
        System.out.println(this.name);
    }
}
