package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Region (
        String name,
        Country country

) implements Location {
    public Region(String name, Country country) {
        this.name = Objects.requireNonNull(name);
        this.country = Objects.requireNonNull(country);
    }
}
