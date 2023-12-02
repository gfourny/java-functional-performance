package javafunctionalperformance.domain.model;

import java.util.Objects;

public record City (
        String name,
        Integer postalCode,
        Department department

) implements Location{
    public City(String name, Integer postalCode, Department department) {
        this.name = Objects.requireNonNull(name);
        this.postalCode = Objects.requireNonNull(postalCode);
        this.department = Objects.requireNonNull(department);
    }
}
