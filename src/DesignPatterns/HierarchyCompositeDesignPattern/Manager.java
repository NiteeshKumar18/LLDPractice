package DesignPatterns.HierarchyCompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Hierarchy {

    private final String id;
    private final List<Hierarchy> hierarchyList;

    private final String name;


    public void addPeople(Hierarchy hierarchy) {
        this.hierarchyList.add(hierarchy);
    }

    public Manager(String id, String name) {
        this.id = id;
        this.hierarchyList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void print() {
      System.out.println("Starting to print reportees for "+ this.name);

      for(Hierarchy hierarchy: hierarchyList){
          hierarchy.print();
      }
    }
}
