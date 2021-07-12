package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;

public interface ScriptBuilder<T extends Collection<?>> {
    Script<T> buildScript(List<String> commandStrings);
}
