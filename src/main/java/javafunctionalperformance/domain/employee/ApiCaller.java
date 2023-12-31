package javafunctionalperformance.domain.employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ApiCaller<T> {

    static <T, U> Mapper<T, U> from(Supplier<List<U>> supplier) {
        return mapper -> CompletableFuture.supplyAsync(supplier)
                .thenApply(mapper)
                .join();
    }

    List<T> call();

    interface Mapper<T, U> {
        List<T> map(Function<List<U>, List<T>> mapper);

        default ApiCaller<T> transform(Function<List<U>, List<T>> mapper) {
            return () -> map(mapper);
        }
    }
}
