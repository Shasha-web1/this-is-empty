package com.example.sqa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReleaseReadinessTest {
    @Test
    void evaluate_green() {
        ReleaseReadiness rr = new ReleaseReadiness();
        assertEquals(ReleaseReadiness.Status.GREEN, rr.evaluate(90, 0.2, 0.95));
    }
}