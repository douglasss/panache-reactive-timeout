package org.acme;

import java.util.List;
import java.util.function.Function;

public record PageResult<T>(long count, List<T> content) {

    public <D> PageResult<D> map(Function<T, D> mapper) {
        return new PageResult<>(
                count,
                content.stream().map(mapper).toList()
        );
    }
}
