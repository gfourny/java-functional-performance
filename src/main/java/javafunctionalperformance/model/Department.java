package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Department (
        String name,
        Integer departmentNumber,
        List<City> cities
) implements Location {
    public Department(String name, Integer departmentNumber, List<City> cities) {
        this.name = Objects.requireNonNull(name);
        this.departmentNumber = departmentNumber;
        this.cities = List.copyOf(cities);
    }
}
