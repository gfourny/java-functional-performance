package javafunctionalperformance.domain.model;

import java.util.Objects;

public record Country (
        String name

) implements Location {
    public Country(String name) {
        this.name = Objects.requireNonNull(name);
    }
}
