package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(123, "abc", "abc");
        Student cloneStudent = (Student) student.clone();

        /*
        Take aways:

        Now client doesnt have to copy everything one by one
         */
    }
}
