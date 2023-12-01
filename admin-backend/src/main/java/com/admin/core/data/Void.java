package com.admin.core.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class Void {
    public static final ThreadLocal<Void> VOID = ThreadLocal.withInitial(Void::new);

    private Void() {
    }

    public static <T> Void exec(final Consumer<T> action, final T input) {
        action.accept(input);
        return VOID.get();
    }

    public static <T, U> Void exec(final BiConsumer<T, U> action, final T first, final U second) {
        action.accept(first, second);
        return VOID.get();
    }
}