package com.example.sqa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class QualityMetricsTest {
    @Test
    void defectDensity_ok() {
        assertEquals(5.0, QualityMetrics.defectDensity(10, 2.0), 1e-9);
    }

    @Test
    void dre_ok() {
        assertEquals(0.8, QualityMetrics.dre(8, 10), 1e-9);
    }

    @Test
    void mttf_ok() {
        assertEquals(5.0, QualityMetrics.mttf(List.of(4.0, 6.0)), 1e-9);
    }

    @Test
    void rework_ok() {
        assertEquals(0.25, QualityMetrics.reworkPercentage(10, 40), 1e-9);
    }
}