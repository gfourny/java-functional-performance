package javafunctionalperformance.domain.employee;

import javafunctionalperformance.domain.annotation.DomainService;
import javafunctionalperformance.domain.employee.api.EmployeeServiceAPI;
import javafunctionalperformance.domain.employee.exception.EmployeeException;
import javafunctionalperformance.domain.employee.spi.RecupererEmployee;
import javafunctionalperformance.domain.model.Compagny;
import javafunctionalperformance.domain.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@DomainService
public class EmployeeService implements EmployeeServiceAPI {

    private final RecupererEmployee employee;

    public EmployeeService(RecupererEmployee employee) {
        this.employee = employee;
    }

    @Override
    public List<Employee> listAllEmployees(){
        return Optional.ofNullable(employee.listAll()).orElseGet(List::of);
    }

    @Override
    public Employee getByLastName(String lastName){
        return Optional.ofNullable(employee.getByLastName(lastName))
                .orElseThrow(() -> new EmployeeException(String.format("l'employee %s n'a pas été trouvé", lastName)));
    }

    @Override
    public Map<Compagny, List<Employee>> listEmployeesByCompany(){
        return Optional.of(employee)
                .map(RecupererEmployee::listAll)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Employee::compagny));
    }
}
