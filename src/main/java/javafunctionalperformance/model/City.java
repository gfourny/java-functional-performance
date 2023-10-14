package javafunctionalperformance.model;

import java.util.List;
import java.util.Objects;

public record City (
        String name,
        Integer postalCode,
        List<Compagny> compagnies
) implements Location{
    public City(String name, Integer postalCode, List<Compagny> compagnies) {
        this.name = Objects.requireNonNull(name);
        this.postalCode = Objects.requireNonNull(postalCode);
        this.compagnies = List.copyOf(compagnies);
    }
}
