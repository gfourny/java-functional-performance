package javafunctionalperformance.domain.model;


import java.util.Objects;
import java.util.function.Consumer;

public record Employee(
        String firstName,
        String lastName,
        String address,
        Integer postalCode,
        Integer age,
        Long socialSecurityNumber,
        Integer salary,
        Compagny compagny
) {

    public Employee {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(address);
        Objects.requireNonNull(socialSecurityNumber);
    }

    public static Employee builder(Consumer<EmployeeBuilder> consumer){
        final var builder = new EmployeeBuilder();
        consumer.accept(builder);
        return builder.build();
    }

    public static Employee of(String firstName,
                              String lastName,
                              String address,
                              Integer postalCode,
                              Integer age,
                              Long socialSecurityNumber,
                              Integer salary,
                              Compagny compagny){
        return new Employee(firstName, lastName, address, postalCode, age, socialSecurityNumber, salary, compagny);
    }
}
