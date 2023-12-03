package javafunctionalperformance.infra.employee.router;

import javafunctionalperformance.domain.employee.api.EmployeeServiceAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class EmployeeRoutingConfiguration {

    private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);

    private final EmployeeServiceAPI employeeServiceAPI;

    @Bean
    public RouterFunction<ServerResponse> employeeRouterFunction() {
        return route()
                .GET("/users", ACCEPT_JSON, request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).body(employeeServiceAPI.listAllEmployees()))
                .GET("/users/{lastName}", ACCEPT_JSON, request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(employeeServiceAPI.getByLastName(request.pathVariable("lastName"))))
                .GET("/usersByCompagnies", ACCEPT_JSON, request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).body(employeeServiceAPI.listEmployeesByCompany()))
                .build();
    }
}
