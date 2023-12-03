package javafunctionalperformance.infra.config;

import javafunctionalperformance.JavaFunctionalPerformanceApplication;
import javafunctionalperformance.domain.annotation.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackageClasses = {JavaFunctionalPerformanceApplication.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class})}
)
public class DomainConfig {
}
