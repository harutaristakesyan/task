package com.um.core.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class Void {
    public static final ThreadLocal<Void> VOID = ThreadLocal.withInitial(Void::new);

    private Void() {
    }

    public static <T> Void exec(Consumer<T> action, T input) {
        action.accept(input);
        return VOID.get();
    }

    public static <T, U> Void exec(BiConsumer<T, U> action, T first, U second) {
        action.accept(first, second);
        return VOID.get();
    }
}