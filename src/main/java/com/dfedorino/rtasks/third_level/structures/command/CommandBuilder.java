package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;

public interface CommandBuilder<T extends Collection<?>> {
    List<Command<T>> buildCommands();
}
