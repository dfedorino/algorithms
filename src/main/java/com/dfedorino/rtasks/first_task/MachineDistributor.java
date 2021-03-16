package com.dfedorino.rtasks.first_task;

public class MachineDistributor {
    private final int ramPerMachine;

    public MachineDistributor(int ramPerMachine) {
        this.ramPerMachine = ramPerMachine;
    }

    private int checkRam(int ramPerMachine) {
        if (ramPerMachine < 0) {
            throw new IllegalArgumentException("Given RAM amount is negative");
        }
        return ramPerMachine;
    }
}
