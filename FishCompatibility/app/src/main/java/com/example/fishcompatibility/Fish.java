package com.example.fishcompatibility;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

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

    @Override
    public int describeContents() {
        return 0;
    }

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

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.sciName = source.readString();
        this.vore = source.readString();
        this.imageUrl = source.readString();
        this.aliases = source.createStringArray();
        this.foodType = source.createStringArray();
        this.substrate = source.createStringArray();
        this.minCurr = source.readInt();
        this.maxCurr = source.readInt();
        this.minSwimLvl = source.readInt();
        this.maxSwimLvl = source.readInt();
        this.minPop = source.readInt();
        this.maxPop = source.readInt();
        this.minTemp = source.readDouble();
        this.maxTemp = source.readDouble();
        this.minAcidity = source.readDouble();
        this.maxAcidity = source.readDouble();
        this.minGenHard = source.readDouble();
        this.maxGenHard = source.readDouble();
        this.minCarbHard = source.readDouble();
        this.maxCarbHard = source.readDouble();
        this.size = source.readDouble();
        this.edibleSize = source.readDouble();
        this.lifeExp = source.readDouble();
        this.finNipper = source.readByte() != 0;
        this.longFins = source.readByte() != 0;
        this.aggressive = source.readByte() != 0;
        this.hardy = source.readByte() != 0;
        this.territorial = source.readByte() != 0;
        this.fast = source.readByte() != 0;
    }

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
}
