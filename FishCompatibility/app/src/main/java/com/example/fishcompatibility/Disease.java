package com.example.fishcompatibility;

import android.os.Parcel;
import android.os.Parcelable;

public class Disease implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(this.treatment);
        dest.writeString(this.name);
        dest.writeStringArray(this.aliases);
        dest.writeStringArray(this.symptoms);
        dest.writeStringArray(this.causes);
        dest.writeStringArray(this.prevention);
    }

    protected Disease(Parcel in) {
        this.treatment = in.createStringArray();
        this.name = in.readString();
        this.aliases = in.createStringArray();
        this.symptoms = in.createStringArray();
        this.causes = in.createStringArray();
        this.prevention = in.createStringArray();
    }

    public static final Parcelable.Creator<Disease> CREATOR = new Parcelable.Creator<Disease>() {
        @Override
        public Disease createFromParcel(Parcel source) {
            return new Disease(source);
        }

        @Override
        public Disease[] newArray(int size) {
            return new Disease[size];
        }
    };
}
