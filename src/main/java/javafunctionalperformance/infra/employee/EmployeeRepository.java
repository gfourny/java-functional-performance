package javafunctionalperformance.infra.employee;

import javafunctionalperformance.domain.employee.spi.RecupererEmployee;
import javafunctionalperformance.domain.model.Compagny;
import javafunctionalperformance.domain.model.CompanyStatus;
import javafunctionalperformance.domain.model.Employee;
import javafunctionalperformance.domain.model.EmployeeBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EmployeeRepository implements RecupererEmployee {
    @Override
    public List<Employee> listAll() {
        return List.of(
                Employee.builder(builder -> builder
                        .firstName("Marc")
                        .lastName("Arnaud")
                        .address("adresse arnaud")
                        .postalCode(56)
                        .age(52)
                        .socialSecurityNumber(19510572215651L)
                        .salary(82000)
                        .compagny(
                                Compagny.builder(compagnyBuilder -> compagnyBuilder
                                        .name("Ent1")
                                        .employees(List.of())
                                        .branches(List.of())
                                        .creationDate(LocalDate.of(2008, 9, 10))
                                        .headquarters("Paris")
                                        .status(CompanyStatus.EURL)
                                        .sirenNumber("179365874")
                                        .siretNumber("1778961648618964"))
                        )),
                EmployeeBuilder.one()
                        .firstName("Guillaume")
                        .lastName("Fourny")
                        .address("address")
                        .postalCode(44)
                        .age(28)
                        .socialSecurityNumber(1951057289951L)
                        .salary(50000)
                        .compagny(Compagny.builder(compagnyBuilder -> compagnyBuilder
                                .name("SFEIR")
                                .employees(List.of())
                                .branches(List.of())
                                .creationDate(LocalDate.of(1998, 9, 10))
                                .headquarters("Paris")
                                .status(CompanyStatus.SA)
                                .sirenNumber("179365074")
                                .siretNumber("1778961648618964")))
                        .build(),
                EmployeeBuilder.one()
                        .firstName("Michel")
                        .lastName("Dupont")
                        .address("address")
                        .postalCode(49)
                        .age(54)
                        .socialSecurityNumber(1801057289951L)
                        .salary(80000)
                        .compagny(Compagny.builder(compagnyBuilder -> compagnyBuilder
                                .name("Ent1")
                                .employees(List.of())
                                .branches(List.of())
                                .creationDate(LocalDate.of(2008, 9, 10))
                                .headquarters("Paris")
                                .status(CompanyStatus.EURL)
                                .sirenNumber("179365874")
                                .siretNumber("1778961648618964")))
                        .build()
        );
    }

    @Override
    public Employee getByLastName(String lastname) {
        return EmployeeBuilder.one()
                .firstName("Guillaume")
                .lastName("Fourny")
                .address("address")
                .postalCode(44)
                .age(28)
                .socialSecurityNumber(1951057289951L)
                .salary(50000)
                .compagny(null)
                .build();
    }
}
