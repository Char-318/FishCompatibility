package com.example.fishcompatibility;

public class Disease {
    private final String name;
    private final String[] aliases;
    private final String[] symptoms;
    private final String[] causes;
    private final String[] prevention;
    private final String[] treatment;

    public Disease(String pName, String[] pAliases, String[] pSymptoms, String[] pCauses,
                   String[] pPrevention, String[] pTreatment) {
        name = pName;
        aliases = pAliases;
        symptoms = pSymptoms;
        causes = pCauses;
        prevention = pPrevention;
        treatment = pTreatment;

    }

    public String getName() { return name; }
    public String[] getAliases() { return aliases; }
    public String[] getSymptoms() { return symptoms; }
    public String[] getCauses() { return causes; }
    public String[] getPrevention() { return prevention; }
    public String[] getTreatment() { return treatment; }
}
