package javafunctionalperformance.domain.model;


import java.util.Objects;

public record Employee(
        String firstName,
        String lastName,
        String address,
        Integer postalCode,
        Integer age,
        Integer socialSecurityNumber,
        Integer salary,
        Compagny compagny
) {

    public Employee {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(address);
        Objects.requireNonNull(socialSecurityNumber);
        Objects.requireNonNull(compagny);
    }
}
