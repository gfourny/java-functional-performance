package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Country (
        String name

) implements Location {
    public Country(String name) {
        this.name = Objects.requireNonNull(name);
    }
}
