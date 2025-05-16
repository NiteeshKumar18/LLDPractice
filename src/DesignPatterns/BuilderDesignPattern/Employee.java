package DesignPatterns.BuilderDesignPattern;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String jobTitle;
    private String department;
    private String managerId;
    private String officeLocation;
    private String employmentType; // e.g., Full-time, Part-time, Contract
    private String employmentStatus; // e.g., Active, Terminated
    private String hireDate;
    private String terminationDate;
    private String birthDate;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String ssn; // Social Security Number or equivalent
    private String taxId;
    private String bankAccountNumber;
    private String bankName;
    private String emergencyContact;
    private String emergencyContactPhone;

    // Constructor for builder
    public Employee(EmployeeBuilder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.alternatePhoneNumber = builder.alternatePhoneNumber;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.jobTitle = builder.jobTitle;
        this.department = builder.department;
        this.managerId = builder.managerId;
        this.officeLocation = builder.officeLocation;
        this.employmentType = builder.employmentType;
        this.employmentStatus = builder.employmentStatus;
        this.hireDate = builder.hireDate;
        this.terminationDate = builder.terminationDate;
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
        this.maritalStatus = builder.maritalStatus;
        this.nationality = builder.nationality;
        this.ssn = builder.ssn;
        this.taxId = builder.taxId;
        this.bankAccountNumber = builder.bankAccountNumber;
        this.bankName = builder.bankName;
        this.emergencyContact = builder.emergencyContact;
        this.emergencyContactPhone = builder.emergencyContactPhone;
    }
}
