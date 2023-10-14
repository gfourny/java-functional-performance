package javafunctionalperformance.model;

import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record Country (
        String name,
        List<Region> regions
) implements Location {
    public Country(String name, List<Region> regions) {
        this.name = Objects.requireNonNull(name);
        this.regions = List.copyOf(regions);
    }
}
