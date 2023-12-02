package javafunctionalperformance.domain.employee.spi;

import javafunctionalperformance.domain.model.Employee;

import java.util.List;

public interface RecupererEmployee {

    List<Employee> listAll();

    Employee getByLastName(String lastname);
}
