package DesignPatterns.Prototype;

public class Student implements Protype {

    private int rollNo;
    private String name;
    private String address;

    public Student(int rollNo, String name, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    @Override
    public Protype clone() {
        return new Student(this.rollNo, this.name, this.address);
    }
}
