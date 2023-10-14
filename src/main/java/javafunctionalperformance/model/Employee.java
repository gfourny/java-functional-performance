package javafunctionalperformance.model;

import lombok.Builder;

import java.util.Objects;

@Builder
public record Employee(
        String firstName,
        String lastName,
        String address,
        Integer postalCode,
        Integer age,
        Integer socialSecurityNumber,
        Integer salary
) {

    public Employee {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(address);
        Objects.requireNonNull(socialSecurityNumber);
    }
}
