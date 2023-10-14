package javafunctionalperformance.model;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Builder
public record Compagny(
        String name,
        String sirenNumber,
        String siretNumber,
        LocalDate creationDate,
        List<Location> branches,
        String headquarters,
        CompanyStatus Status,
        List<Employee> employees
) {

    private static final int SIREN_LENGTH = 9;

    public Compagny(String name, String  sirenNumber, String  siretNumber, LocalDate creationDate,
                    List<Location> branches, String headquarters, CompanyStatus Status, List<Employee> employees) {
        this.name = Objects.requireNonNull(name);
        this.sirenNumber = sirenNumberValidation(sirenNumber);
        this.siretNumber = Objects.requireNonNull(siretNumber);
        this.creationDate = creationDate;
        this.branches = List.copyOf(branches);
        this.headquarters = headquarters;
        this.Status = Status;
        this.employees = List.copyOf(employees);
    }

    private String sirenNumberValidation(String sirenNumber) {
        Objects.requireNonNull(sirenNumber);

        Predicate<String> isValidSirenLength = s -> s.length() == SIREN_LENGTH;

        return Optional.of(sirenNumber)
                .filter(isValidSirenLength)
                .orElseThrow(IllegalArgumentException::new);
    }
}
