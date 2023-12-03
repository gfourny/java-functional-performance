package javafunctionalperformance.domain.model;


import java.math.BigInteger;
import java.util.Objects;

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
}
