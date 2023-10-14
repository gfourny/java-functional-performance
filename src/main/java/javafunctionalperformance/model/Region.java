package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Region (
        String name,
        List<Department> departments
) implements Location {
    public Region(String name, List<Department> departments) {
        this.name = Objects.requireNonNull(name);
        this.departments = List.copyOf(departments);
    }
}
