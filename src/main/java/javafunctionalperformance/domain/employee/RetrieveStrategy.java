package javafunctionalperformance.domain.employee;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface RetrieveStrategy<T> {

    static <T> RetrieveStrategy<T> from(Supplier<List<T>> supplier) {
        return () -> Optional.ofNullable(supplier.get()).orElseGet(List::of);
    }

    List<T> retrieve();
}
