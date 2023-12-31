package javafunctionalperformance.domain.model;

import java.time.LocalDate;
import java.util.List;

public class CompagnyBuilder {
    private String name;
    private String sirenNumber;
    private String siretNumber;
    private LocalDate creationDate;
    private List<Location> branches;
    private String headquarters;
    private CompanyStatus status;
    private List<Employee> employees;

    public CompagnyBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CompagnyBuilder sirenNumber(String sirenNumber) {
        this.sirenNumber = sirenNumber;
        return this;
    }

    public CompagnyBuilder siretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
        return this;
    }

    public CompagnyBuilder creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public CompagnyBuilder branches(List<Location> branches) {
        this.branches = branches;
        return this;
    }

    public CompagnyBuilder headquarters(String headquarters) {
        this.headquarters = headquarters;
        return this;
    }

    public CompagnyBuilder status(CompanyStatus status) {
        this.status = status;
        return this;
    }

    public CompagnyBuilder employees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public Compagny build() {
        return Compagny.of(name, sirenNumber, siretNumber, creationDate, branches, headquarters, status, employees);
    }
}