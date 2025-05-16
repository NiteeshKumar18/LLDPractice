package DesignPatterns.BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Employee employee = employeeBuilder.setEmployeeId("1234").setBankAccountNumber("123").build();

    }

/*
Imp take away is lets say employee have 30 fields and we may have to create so many diff types of constructors if all of them are not compulsary fields.Now with this we dont need constructors.But disadvantages is fields duplication
 */
}
