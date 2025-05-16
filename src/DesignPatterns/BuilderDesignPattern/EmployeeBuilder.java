package DesignPatterns.BuilderDesignPattern;

public class EmployeeBuilder {
    public String employeeId;
    public String firstName;
    public String lastName;
    public String middleName;
    public String fullName;
    public String email;
    public String phoneNumber;
    public String alternatePhoneNumber;
    public String address;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public String jobTitle;
    public String department;
    public String managerId;
    public String officeLocation;
    public String employmentType;
    public String employmentStatus;
    public String hireDate;
    public String terminationDate;
    public String birthDate;
    public String gender;
    public String maritalStatus;
    public String nationality;
    public String ssn;
    public String taxId;
    public String bankAccountNumber;
    public String bankName;
    public String emergencyContact;
    public String emergencyContactPhone;


    public EmployeeBuilder setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public EmployeeBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public EmployeeBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeBuilder setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
        return this;
    }

    public EmployeeBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public EmployeeBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public EmployeeBuilder setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public EmployeeBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public EmployeeBuilder setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public EmployeeBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder setManagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }

    public EmployeeBuilder setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
        return this;
    }

    public EmployeeBuilder setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public EmployeeBuilder setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
        return this;
    }

    public EmployeeBuilder setHireDate(String hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public EmployeeBuilder setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }

    public EmployeeBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public EmployeeBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public EmployeeBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public EmployeeBuilder setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    public EmployeeBuilder setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public EmployeeBuilder setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public EmployeeBuilder setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public EmployeeBuilder setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
        return this;
    }

    public EmployeeBuilder setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
        return this;
    }

    public Employee build() {
        return new Employee(this);
    }


}
