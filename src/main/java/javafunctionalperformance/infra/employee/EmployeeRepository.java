package javafunctionalperformance.infra.employee;

import javafunctionalperformance.domain.employee.spi.RecupererEmployee;
import javafunctionalperformance.domain.model.Employee;

import java.util.List;

public class EmployeeRepository implements RecupererEmployee {
    @Override
    public List<Employee> listAll() {
        return null;
    }

    @Override
    public Employee getByLastName(String lastname) {
        return null;
    }
}
