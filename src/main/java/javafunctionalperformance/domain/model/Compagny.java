package javafunctionalperformance.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

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
        this.name = requireNonNull(name, "Le nom de l'entreprise est obligatoire");
        this.sirenNumber = sirenNumberValidation(sirenNumber);
        this.siretNumber = requireNonNull(siretNumber, "Le numéro de SIRET est obligatoire");
        this.creationDate = creationDate;
        this.branches = List.copyOf(branches);
        this.headquarters = headquarters;
        this.Status = Status;
        this.employees = List.copyOf(employees);
    }

    private String sirenNumberValidation(String sirenNumber) {
        requireNonNull(sirenNumber, "Le numéro de SIREN est obligatoire");

        Predicate<String> isValidSirenLength = s -> s.length() == SIREN_LENGTH;

        return Optional.of(sirenNumber)
                .filter(isValidSirenLength)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Compagny of(String name,
                              String sirenNumber,
                              String siretNumber,
                              LocalDate creationDate,
                              List<Location> branches,
                              String headquarters,
                              CompanyStatus Status,
                              List<Employee> employees){
        return new Compagny(name, sirenNumber, siretNumber, creationDate, branches, headquarters, Status, employees);
    }

    public static Compagny builder(Consumer<CompagnyBuilder> consumer){
        final var builder = new CompagnyBuilder();
        consumer.accept(builder);
        return builder.build();
    }
}
