package javafunctionalperformance.domain.employee;

import javafunctionalperformance.domain.annotation.DomainService;
import javafunctionalperformance.domain.employee.api.EmployeeServiceAPI;
import javafunctionalperformance.domain.employee.exception.EmployeeException;
import javafunctionalperformance.domain.employee.spi.RecupererEmployee;
import javafunctionalperformance.domain.model.Compagny;
import javafunctionalperformance.domain.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.groupingBy;

@DomainService
public class EmployeeService implements EmployeeServiceAPI {

    private final RecupererEmployee employee;

    public EmployeeService(RecupererEmployee employee) {
        this.employee = employee;
    }

    private static List<String> mapToFirstNameList(List<Employee> employees) {
        return employees.stream()
                .map(Employee::firstName)
                .toList();
    }

    @Override
    public List<Employee> listAllEmployees() {
        return getEmployees();
    }

    private List<Employee> getEmployees() {
        return RetrieveStrategy.from(employee::listAll).retrieve();
    }

    @Override
    public Employee getByLastName(String lastName) {
        return ofNullable(employee.getByLastName(lastName))
                .orElseThrow(() -> new EmployeeException(String.format("l'employee %s n'a pas été trouvé", lastName)));
    }

    @Override
    public Map<Compagny, List<Employee>> listEmployeesByCompany() {
        return getEmployees()
                .stream()
                .collect(groupingBy(Employee::compagny));
    }

    @Override
    public List<String> listFirstName() {
        return ApiCaller.<String, Employee>from(this::getEmployees)
                .transform(EmployeeService::mapToFirstNameList)
                .call();
    }
}
