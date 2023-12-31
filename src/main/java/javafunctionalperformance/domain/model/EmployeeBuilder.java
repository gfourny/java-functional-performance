package javafunctionalperformance.domain.model;

public class EmployeeBuilder {
    private String firstName;
    private String lastName;
    private String address;
    private Integer postalCode;
    private Integer age;
    private Long socialSecurityNumber;
    private Integer salary;
    private Compagny compagny;

    public static EmployeeBuilder one(){
        return new EmployeeBuilder();
    }

    public EmployeeBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder address(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder postalCode(Integer postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public EmployeeBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder socialSecurityNumber(Long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        return this;
    }

    public EmployeeBuilder salary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeBuilder compagny(Compagny compagny) {
        this.compagny = compagny;
        return this;
    }

    public Employee build() {
        return Employee.of(firstName, lastName, address, postalCode, age, socialSecurityNumber, salary, compagny);
    }
}