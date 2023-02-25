package com.example.fishcompatibility;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Fish {
    private final String name;
    private final String sciName;
    private final String vore;
    private final String[] aliases;
    private final String[] foodType;
    private final String[] substrate;
    private final int minCurr;
    private final int maxCurr;
    private final int minSwimLvl;
    private final int maxSwimLvl;
    private final int minPop;
    private final int maxPop;
    private final double minTemp;
    private final double maxTemp;
    private final double minAcidity;
    private final double maxAcidity;
    private final double minGenHard;
    private final double maxGenHard;
    private final double minCarbHard;
    private final double maxCarbHard;
    private final double size;
    private final double edibleSize;
    private final double lifeExp;
    private final boolean finNipper;
    private final boolean longFins;
    private final boolean aggressive;
    private final boolean hardy;
    private final boolean territorial;
    private final boolean fast;
    private final Drawable image;

    public Fish(String pName, String pSciName, String pVore, String[] pAliases, String[] pFoodType,
                String[] pSubstrate, int pMinCurr, int pMaxCurr, int pMinSwimLvl, int pMaxSwimLvl,
                int pMinPop, int pMaxPop, double pMinTemp, double pMaxTemp, double pMinAcidity,
                double pMaxAcidity, double pMinGenHard, double pMaxGenHard, double pMinCarbHard,
                double pMaxCarbHard, double pSize, double pEdibleSize, double pLifeExp,
                boolean pFinNipper, boolean pLongFins, boolean pAggressive, boolean pHardy,
                boolean pTerritorial, boolean pFast, Drawable pImage)
    {
        name = pName;
        sciName = pSciName;
        vore = pVore;
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
        image = pImage;
    }

    // Getters
    public String getName() { return name; }
    public String getSciName() { return sciName; }
    public String getVore() { return vore; }
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
    public Drawable getImage() { return image; }
}
