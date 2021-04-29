package com.dfedorino.rtasks;

import lombok.Value;

import java.util.concurrent.Callable;

@Value
public class Algorithms {
    int timesToRun;

    public <T> double measureTimeConsumption(Callable<T> task) throws Exception {
        double totalTime = 0;
        for (int times = 1; times <= timesToRun; times++) {
            long start = System.nanoTime();
            task.call();
            long end = System.nanoTime();
            totalTime += end - start;
        }
        return (totalTime / timesToRun) / 1_000_000_000.0;
    }

    public <T> double measureRamConsumption(Callable<T> task) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        double ramTotalConsumption = 0;
        for (int i = 0; i < timesToRun; i++) {
            System.gc();
            long ramUsedBefore = runtime.totalMemory() - runtime.freeMemory();
            task.call();
            long ramUsedAfter = runtime.totalMemory() - runtime.freeMemory();
            System.gc();
            ramTotalConsumption += ramUsedAfter - ramUsedBefore;
        }
        return (ramTotalConsumption / timesToRun) / 1000;
    }

    public <T> String consumedTime(Callable<T> task) {
        try {
            return "consumed time -> " + measureTimeConsumption(task) + " sec";
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public <T> String consumedRam(Callable<T> task) {
        try {
            return "consumed ram -> " + String.format("%.2f", measureRamConsumption(task)) + "KB";
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
