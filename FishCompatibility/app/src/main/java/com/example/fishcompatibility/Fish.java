package com.example.fishcompatibility;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Fish implements Parcelable {
    private String name;
    private String sciName;
    private String vore;

    private String imageUrl;
    private String[] aliases;
    private String[] foodType;
    private String[] substrate;
    private int minCurr;
    private int maxCurr;
    private int minSwimLvl;
    private int maxSwimLvl;
    private int minPop;
    private int maxPop;
    private double minTemp;
    private double maxTemp;
    private double minAcidity;
    private double maxAcidity;
    private double minGenHard;
    private double maxGenHard;
    private double minCarbHard;
    private double maxCarbHard;
    private double size;
    private double edibleSize;
    private double lifeExp;
    private boolean finNipper;
    private boolean longFins;
    private boolean aggressive;
    private boolean hardy;
    private boolean territorial;
    private boolean fast;

    /**
     * Constructor for the fish object.
     * @param pName Name of the fish.
     * @param pSciName Scientific name of the fish.
     * @param pVore Whether the fish is a herbivore, omnivore or carnivore.
     * @param pImageUrl Name of the image of the fish in the resource file.
     * @param pAliases List of any aliases the fish has.
     * @param pFoodType List of the types of food the fish eats.
     * @param pSubstrate List of substrates the fish can have.
     * @param pMinCurr Minimum water current the fish can have. 0 - no water current, 1 - weak water
     *                 current, 2 - medium water current, 3 - strong water current.
     * @param pMaxCurr Maximum water current the fish can have. Same key as above.
     * @param pMinSwimLvl Minimum level in the tank the fish will swim at. 0 - bottom of the tank,
     *                    1 - middle of the tank, 2 - top of the tank.
     * @param pMaxSwimLvl Maximum level in the tank the fish will swim at. Same key as above.
     * @param pMinPop Minimum amount of fish that can be kept together.
     * @param pMaxPop Maximum amount of fish that can be kept together. 0 if there is no maximum.
     * @param pMinTemp Minimum temperature of the water in degrees Celsius.
     * @param pMaxTemp Maximum temperature of the water in degrees Celsius.
     * @param pMinAcidity Minimum acidity level of the water in pH.
     * @param pMaxAcidity Maximum acidity level of the water in pH.
     * @param pMinGenHard Minimum general hardness of the water in dGH.
     * @param pMaxGenHard Maximum general hardness of the water in dGH.
     * @param pMinCarbHard Minimum carbonate hardness of the water in dKH.
     * @param pMaxCarbHard Maximum carbonate hardness of the water in dKH.
     * @param pSize Average size of the fish in cm.
     * @param pEdibleSize The maximum size this fish can eat in cm. Used to checks if this fish will be
     *                    able to eat other fish in the tank.
     * @param pLifeExp Average life expectancy of the fish in years.
     * @param pFinNipper True if the fish is likely to nip long fins, false if not.
     * @param pLongFins True if the fish has long fins, false if not.
     * @param pAggressive True if the fish is likely to be aggressive, false if not.
     * @param pHardy True if the fish can handle aggressive fish, false if not.
     * @param pTerritorial True if the fish is likely to get territorial, false if not.
     * @param pFast True if the fish is a fast swimmer, false if not.
     */
    public Fish(String pName, String pSciName, String pVore, String pImageUrl, String[] pAliases,
                String[] pFoodType, String[] pSubstrate, int pMinCurr, int pMaxCurr,
                int pMinSwimLvl, int pMaxSwimLvl, int pMinPop, int pMaxPop, double pMinTemp,
                double pMaxTemp, double pMinAcidity, double pMaxAcidity, double pMinGenHard,
                double pMaxGenHard, double pMinCarbHard, double pMaxCarbHard, double pSize,
                double pEdibleSize, double pLifeExp, boolean pFinNipper, boolean pLongFins,
                boolean pAggressive, boolean pHardy, boolean pTerritorial, boolean pFast)
    {
        name = pName;
        sciName = pSciName;
        vore = pVore;
        imageUrl = pImageUrl;
        aliases = pAliases;
        foodType = pFoodType;
        substrate = pSubstrate;
        minCurr = pMinCurr;
        maxCurr = pMaxCurr;
        minSwimLvl = pMinSwimLvl;
        maxSwimLvl = pMaxSwimLvl;
        minPop = pMinPop;
        maxPop = pMaxPop;
        minTemp = pMinTemp;
        maxTemp = pMaxTemp;
        minAcidity = pMinAcidity;
        maxAcidity = pMaxAcidity;
        minGenHard = pMinGenHard;
        maxGenHard = pMaxGenHard;
        minCarbHard = pMinCarbHard;
        maxCarbHard = pMaxCarbHard;
        size = pSize;
        edibleSize = pEdibleSize;
        lifeExp = pLifeExp;
        finNipper = pFinNipper;
        longFins = pLongFins;
        aggressive = pAggressive;
        hardy = pHardy;
        territorial = pTerritorial;
        fast = pFast;
    }

    // Getters
    public String getName() { return name; }
    public String getSciName() { return sciName; }
    public String getVore() { return vore; }
    public String getImageUrl() { return imageUrl; }
    public String[] getAliases() { return aliases; }
    public String[] getFoodType() { return foodType; }
    public String[] getSubstrate() { return substrate; }
    public int getMinCurr() { return minCurr; }
    public int getMaxCurr() { return maxCurr; }
    public int getMinSwimLvl() { return minSwimLvl; }
    public int getMaxSwimLvl() { return maxSwimLvl; }
    public int getMinPop() { return minPop; }
    public int getMaxPop() { return maxPop; }
    public double getMinTemp() { return minTemp; }
    public double getMaxTemp() { return maxTemp; }
    public double getMinAcidity() { return minAcidity; }
    public double getMaxAcidity() { return maxAcidity; }
    public double getMinGenHard() { return minGenHard;}
    public double getMaxGenHard() { return maxGenHard;}
    public double getMinCarbHard() { return minCarbHard; }
    public double getMaxCarbHard() { return maxCarbHard; }
    public double getSize() { return size; }
    public double getEdibleSize() { return edibleSize;}
    public double getLifeExp() { return lifeExp; }
    public boolean isFinNipper() { return finNipper; }
    public boolean isLongFins() { return longFins; }
    public boolean isAggressive() { return aggressive; }
    public boolean isHardy() { return hardy; }
    public boolean isTerritorial() { return territorial; }
    public boolean isFast() { return fast; }

    /**
     * Function required to make this object parcelable.
     */
    @Override
    public int describeContents() { return 0; }

    /**
     * Function to write the object to a parcel so it can be sent between activities.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.sciName);
        dest.writeString(this.vore);
        dest.writeString(this.imageUrl);
        dest.writeStringArray(this.aliases);
        dest.writeStringArray(this.foodType);
        dest.writeStringArray(this.substrate);
        dest.writeInt(this.minCurr);
        dest.writeInt(this.maxCurr);
        dest.writeInt(this.minSwimLvl);
        dest.writeInt(this.maxSwimLvl);
        dest.writeInt(this.minPop);
        dest.writeInt(this.maxPop);
        dest.writeDouble(this.minTemp);
        dest.writeDouble(this.maxTemp);
        dest.writeDouble(this.minAcidity);
        dest.writeDouble(this.maxAcidity);
        dest.writeDouble(this.minGenHard);
        dest.writeDouble(this.maxGenHard);
        dest.writeDouble(this.minCarbHard);
        dest.writeDouble(this.maxCarbHard);
        dest.writeDouble(this.size);
        dest.writeDouble(this.edibleSize);
        dest.writeDouble(this.lifeExp);
        dest.writeByte(this.finNipper ? (byte) 1 : (byte) 0);
        dest.writeByte(this.longFins ? (byte) 1 : (byte) 0);
        dest.writeByte(this.aggressive ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hardy ? (byte) 1 : (byte) 0);
        dest.writeByte(this.territorial ? (byte) 1 : (byte) 0);
        dest.writeByte(this.fast ? (byte) 1 : (byte) 0);
    }

    /**
     * Creating a fish object from the parcel.
     * @param in Parcel of the object.
     */
    protected Fish(Parcel in) {
        this.name = in.readString();
        this.sciName = in.readString();
        this.vore = in.readString();
        this.imageUrl = in.readString();
        this.aliases = in.createStringArray();
        this.foodType = in.createStringArray();
        this.substrate = in.createStringArray();
        this.minCurr = in.readInt();
        this.maxCurr = in.readInt();
        this.minSwimLvl = in.readInt();
        this.maxSwimLvl = in.readInt();
        this.minPop = in.readInt();
        this.maxPop = in.readInt();
        this.minTemp = in.readDouble();
        this.maxTemp = in.readDouble();
        this.minAcidity = in.readDouble();
        this.maxAcidity = in.readDouble();
        this.minGenHard = in.readDouble();
        this.maxGenHard = in.readDouble();
        this.minCarbHard = in.readDouble();
        this.maxCarbHard = in.readDouble();
        this.size = in.readDouble();
        this.edibleSize = in.readDouble();
        this.lifeExp = in.readDouble();
        this.finNipper = in.readByte() != 0;
        this.longFins = in.readByte() != 0;
        this.aggressive = in.readByte() != 0;
        this.hardy = in.readByte() != 0;
        this.territorial = in.readByte() != 0;
        this.fast = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Fish> CREATOR = new Parcelable.Creator<Fish>() {
        @Override
        public Fish createFromParcel(Parcel source) {
            return new Fish(source);
        }

        @Override
        public Fish[] newArray(int size) {
            return new Fish[size];
        }
    };

    /**
     * Checks if two fish are compatible with each other.
     * @param fishB Fish to be compared to.
     * @return ZCompatibility object containing whether they are compatible or not and a reason for
     *         them not being compatible if they aren't.
     */
    public Compatibility areFishCompatible(Fish fishB) {
        // If two fish are the same, check if more than one can be kept together
        Compatibility comp;
        if (this == fishB) {
            if (maxPop == 1) {
                comp = new Compatibility("Only one can be in a tank", false);
                return comp;
            } else {
                comp = new Compatibility("n/a", true);
                return comp;
            }
        }

        // Checks if there is at least 3 degrees of overlapping temperatures that satisfy each fish
        double tempDiffA = maxTemp - fishB.getMinTemp();
        double tempDiffB = fishB.getMaxTemp() - minTemp;

        if (tempDiffA < tempDiffB) {
            if (tempDiffA < 3) {
                comp = new Compatibility(
                        "Fish require different temperatures", false);
                return comp;
            }
        } else {
            if (tempDiffB < 3) {
                comp = new Compatibility(
                        "Fish require different temperatures", false);
                return comp;
            }
        }

        // Checks if there is a pH level that satisfies both fish
        double acidityDiffA = maxAcidity - fishB.getMinAcidity();
        double acidityDiffB = fishB.getMaxAcidity() - minAcidity;

        if (acidityDiffA < acidityDiffB) {
            if (acidityDiffA < 0) {
                comp = new Compatibility(
                        "Fish require different levels of acidity", false);
                return comp;
            }
        } else {
            if (acidityDiffB < 0) {
                comp = new Compatibility(
                        "Fish require different levels of acidity", false);
                return comp;
            }
        }

        // Checks if there is a degree of general hardness that satisfies each fish
        double genDiffA = maxGenHard - fishB.getMinGenHard();
        double genDiffB = fishB.getMaxGenHard() - minGenHard;

        if (genDiffA < genDiffB) {
            if (genDiffA < 0) {
                comp = new Compatibility(
                        "Fish require different levels of general hardness", false);
                return comp;
            }
        } else {
            if (genDiffB < 0) {
                comp = new Compatibility(
                        "Fish require different levels of general hardness", false);
                return comp;
            }
        }

        // Checks that there is a degree of carbonate hardness that satisfies each fish
        double carbDiffA = maxCarbHard - fishB.getMinCarbHard();
        double carbDiffB = fishB.getMaxCarbHard() - minCarbHard;

        if (carbDiffA < carbDiffB) {
            if (carbDiffA < 0) {
                comp = new Compatibility(
                        "Fish require different levels of carbonate hardness", false);
                return comp;
            }
        } else {
            if (carbDiffB < 0) {
                comp = new Compatibility(
                        "Fish require different levels of carbonate hardness", false);
                return comp;
            }
        }

        // Checks if one fish may get eaten by the other
        if (size < fishB.getEdibleSize()) {
            comp = new Compatibility(
                    name + " may get eaten", false);
            return comp;
        }
        if (fishB.getSize() < edibleSize) {
            comp = new Compatibility(
                    fishB.getName() + " may get eaten", false);
            return comp;
        }

        // Checks if one fish will nip the fins of the other
        if (finNipper && fishB.isLongFins()) {
            comp = new Compatibility(
                    name + " may nip the fins", false);
            return comp;
        }
        if (fishB.isFinNipper() && longFins) {
            comp = new Compatibility(
                    fishB.getName() + " may nip the fins", false);
            return comp;
        }

        // Checks if one fish will attack and injure the other
        if (aggressive && !fishB.isHardy()) {
            comp = new Compatibility(
                    name + " is too aggressive", false);
            return comp;
        }
        if (fishB.isAggressive() && !hardy) {
            comp = new Compatibility(
                    fishB.getName() + " is too aggressive", false);
            return comp;
        }

        // Checks if fish swim at the same level and if they are territorial
        int swimDiffA = maxSwimLvl - fishB.getMinSwimLvl();
        int swimDiffB = fishB.getMaxSwimLvl() - minSwimLvl;

        if ((swimDiffA > swimDiffB && swimDiffA == 0)
                || (swimDiffA <= swimDiffB && swimDiffB == 0)) {
            if (fishB.isTerritorial()) {
                comp = new Compatibility(
                        fishB.getName() + " is too territorial", false);
                return comp;
            }
            if (territorial) {
                comp = new Compatibility(
                        name + " is too territorial", false);
                return comp;
            }
        }

        // Checks if fish can swim in the same current strength
        int currDiffA = maxCurr - fishB.getMinCurr();
        int currDiffB = fishB.getMaxCurr() - minCurr;

        if (currDiffA < currDiffB) {
            if (currDiffA < 0) {
                comp = new Compatibility(
                        "Fish require different water currents", false);
                return comp;
            }
        } else {
            if (currDiffB < 0) {
                comp = new Compatibility(
                        "Fish require different water currents", false);
                return comp;
            }
        }

        // Checks if one fish is fast and the other is slow and they swim at the same level
        if ((swimDiffA < swimDiffB && swimDiffA >= 0)
                || (swimDiffA >= swimDiffB && swimDiffB >= 0)) {
            if (fast && !fishB.isFast()) {
                comp = new Compatibility(
                        name + " may eat the food before " + fishB.getName() + " can get to it",
                        false);
                return comp;
            }
            if (!fast && fishB.isFast()) {
                comp = new Compatibility(
                        fishB.getName() + " may eat the food before " + name + " can get to it",
                        false);
                return comp;
            }
        }

        // Checks if there is a matching substrate
        for (String subA: substrate) {
            for (String subB : fishB.substrate) {
                if (Objects.equals(subA, subB)) {
                    comp = new Compatibility("n/a", true);
                    return comp;
                }
            }
        }

        comp = new Compatibility("Fish require different substrates", false);
        return comp;
    }
}
