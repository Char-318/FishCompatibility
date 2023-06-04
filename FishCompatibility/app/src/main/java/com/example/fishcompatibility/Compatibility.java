package com.example.fishcompatibility;

public class Compatibility {
    private final String reason;
    private final boolean isComp;

    /**
     * Constructor for the Compatibility object.
     * @param pReason Reason for why the fish are incompatible. n/a when fish are compatible.
     * @param pIsComp True if the fish are compatible, false if not.
     */
    public Compatibility(String pReason, boolean pIsComp) {
        reason = pReason;
        isComp = pIsComp;
    }

    // Getters
    public String getReason() { return reason; }
    public boolean getIsComp() { return isComp; }
}
