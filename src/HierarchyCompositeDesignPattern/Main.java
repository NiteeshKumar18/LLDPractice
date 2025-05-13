package HierarchyCompositeDesignPattern;

import TicTacToe.TicTacToe;

public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("1234","manager1");
        User user1 = new User("1234","Niteesh1","1234");
        Manager manager2 = new Manager("456","manager2");
        User user2 = new User("123","Niteesh2","68976");
        User user3 = new User("213","Niteesh3","78789");
        manager2.addPeople(user3);
        manager2.addPeople(user2);


        manager1.addPeople(user1);
        manager1.addPeople(manager2);
        manager1.print();
    }
}
