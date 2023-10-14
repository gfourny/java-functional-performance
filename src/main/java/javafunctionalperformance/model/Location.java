package javafunctionalperformance.model;

public sealed interface Location permits Country, Department, City, Region {
}
