package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;

public interface Command<T extends Collection<?>> {
    // CommandResult execute(T collection);
    CommandResult execute();
}
