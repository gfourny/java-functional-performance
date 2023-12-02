package javafunctionalperformance.domain.employee.api;

import javafunctionalperformance.domain.model.Compagny;
import javafunctionalperformance.domain.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceAPI {

    List<Employee> listAllEmployees();

    Employee getByLastName(String lastName);

    Map<Compagny, List<Employee>> listEmployeesByCompany();
}
