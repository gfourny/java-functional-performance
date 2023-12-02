package javafunctionalperformance.domain.model;

import java.util.Objects;

public record Region (
        String name,
        Country country

) implements Location {
    public Region(String name, Country country) {
        this.name = Objects.requireNonNull(name);
        this.country = Objects.requireNonNull(country);
    }
}
