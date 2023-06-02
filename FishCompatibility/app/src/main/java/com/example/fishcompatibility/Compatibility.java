package com.example.fishcompatibility;

public class Compatibility {
    private final String reason;
    private final boolean isComp;

    public Compatibility(String pReason, boolean pIsComp) {
        reason = pReason;
        isComp = pIsComp;
    }

    public String getReason() { return reason; }
    public boolean getIsComp() { return isComp; }
}
