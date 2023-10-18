package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Department (
        String name,
        Integer departmentNumber

) implements Location {
    public Department(String name, Integer departmentNumber) {
        this.name = Objects.requireNonNull(name);
        this.departmentNumber = departmentNumber;
    }
}
