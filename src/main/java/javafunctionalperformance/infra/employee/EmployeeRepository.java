package javafunctionalperformance.infra.employee;

import javafunctionalperformance.domain.employee.spi.RecupererEmployee;
import javafunctionalperformance.domain.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepository implements RecupererEmployee {
    @Override
    public List<Employee> listAll() {
        return List.of(
                new Employee(
                        "Guillaume",
                        "Fourny",
                        "address",
                        44,
                        28,
                        1951057289951L,
                        50000,
                        null
                        ),
                new Employee(
                        "Michel",
                        "Dupont",
                        "address",
                        49,
                        54,
                        1801057289951L,
                        80000,
                        null
                )
        );
    }

    @Override
    public Employee getByLastName(String lastname) {
        return new Employee(
                "Guillaume",
                "Fourny",
                "address",
                44,
                28,
                1951057289951L,
                50000,
                null
        );
    }
}
