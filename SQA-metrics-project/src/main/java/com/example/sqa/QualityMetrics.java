package com.example.sqa;

import java.util.List;
import java.util.Objects;

public final class QualityMetrics {
    private QualityMetrics() {}

    public static double defectDensity(int defects, double kloc) {
        validateNonNegative(defects, "defects");
        validatePositive(kloc, "kloc");
        return defects / kloc;
    }

    public static double dre(int removedDuringDev, int totalDefects) {
        validateNonNegative(removedDuringDev, "removedDuringDev");
        validatePositive(totalDefects, "totalDefects");
        if (removedDuringDev > totalDefects) throw new IllegalArgumentException("removedDuringDev cannot exceed totalDefects");
        return (double) removedDuringDev / totalDefects;
    }

    public static double mttf(List<Double> failureTimes) {
        Objects.requireNonNull(failureTimes, "failureTimes");
        if (failureTimes.isEmpty()) throw new IllegalArgumentException("failureTimes must not be empty");
        double sum = 0.0;
        for (Double t : failureTimes) {
            if (t == null || t <= 0.0) throw new IllegalArgumentException("All failure times must be positive");
            sum += t;
        }
        return sum / failureTimes.size();
    }

    public static double reworkPercentage(double reworkEffort, double totalEffort) {
        validateNonNegative(reworkEffort, "reworkEffort");
        validatePositive(totalEffort, "totalEffort");
        if (reworkEffort > totalEffort) throw new IllegalArgumentException("reworkEffort cannot exceed totalEffort");
        return reworkEffort / totalEffort;
    }

    private static void validatePositive(double value, String name) {
        if (value <= 0) throw new IllegalArgumentException(name + " must be > 0");
    }
    private static void validateNonNegative(double value, String name) {
        if (value < 0) throw new IllegalArgumentException(name + " must be >= 0");
    }
}