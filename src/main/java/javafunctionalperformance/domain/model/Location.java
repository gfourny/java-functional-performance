package javafunctionalperformance.domain.model;

public sealed interface Location permits Country, Department, City, Region {
}
