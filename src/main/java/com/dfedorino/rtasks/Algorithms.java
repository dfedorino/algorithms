package com.dfedorino.rtasks;

import lombok.Value;

@Value
public class Algorithms {
    int timesToRun;

    public double measureTimeConsumption(Runnable task) {
        double totalTime = 0;
        for (int times = 1; times <= timesToRun; times++) {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            totalTime += end - start;
        }
        return (totalTime / timesToRun) / 1_000_000_000.0;
    }

    public double measureRamConsumption(Runnable task) {
        Runtime runtime = Runtime.getRuntime();
        double ramTotalConsumption = 0;
        for (int i = 0; i < timesToRun; i++) {
            System.gc();
            long ramUsedBefore = runtime.totalMemory() - runtime.freeMemory();
            task.run();
            long ramUsedAfter = runtime.totalMemory() - runtime.freeMemory();
            System.gc();
            ramTotalConsumption += ramUsedAfter - ramUsedBefore;
        }
        return (ramTotalConsumption / timesToRun) / 1000;
    }

    public String consumedTime(Runnable task) {
        return "consumed time -> " + measureTimeConsumption(task) + " sec";
    }

    public String consumedRam(Runnable task) {
        return "consumed ram -> " + String.format("%.2f", measureRamConsumption(task)) + "KB";
    }
}
