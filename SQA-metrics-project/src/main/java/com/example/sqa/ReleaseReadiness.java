package com.example.sqa;

public class ReleaseReadiness {
    public enum Status { RED, AMBER, GREEN }

    public Status evaluate(double coveragePct, double defectDensity, double dre) {
        if (coveragePct < 0 || coveragePct > 100) throw new IllegalArgumentException("coveragePct must be in [0, 100]");
        if (defectDensity < 0) throw new IllegalArgumentException("defectDensity must be >= 0");
        if (dre < 0 || dre > 1) throw new IllegalArgumentException("DRE must be in [0, 1]");

        boolean goodCoverage = coveragePct >= 80.0;
        boolean lowDefects = defectDensity <= 0.5;
        boolean highDre = dre >= 0.9;

        if (goodCoverage && lowDefects && highDre) return Status.GREEN;
        else if ((goodCoverage && highDre) || (goodCoverage && lowDefects) || (highDre && lowDefects)) return Status.AMBER;
        return Status.RED;
    }
}