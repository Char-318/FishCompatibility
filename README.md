# FishCompatibility

This is an Android application that allows users to find out information on species of fish and diseases and to check if species would be compatible in the same tank.

The data for the fish and diseases is stored at FishCompatibility/app/src/main/res/raw/content.json
This contains a sample dataset of select fish and diseases, which can be expanded by adding items to this file.
The format to add a new fish is:

    "name":STRING,
    "scientificName":STRING,
    "aliases":STRING ARRAY,
    "minTemp":DOUBLE,
    "maxTemp":DOUBLE,
    "minAcidity":DOUBLE,
    "maxAcidity":DOUBLE,
    "minGenHard":DOUBLE,        //General hardness of the water
    "maxGenHard":DOUBLE,
    "minCarbHard":DOUBLE,       //Carbonate hardness of the water
    "maxCarbHard":DOUBLE,
    "vore":STRING,              //Omnivore, herbivore or carnivore
    "foodType":STRING ARRAY,    //E.g. granules, flakes, algae, etc
    "averageSize":DOUBLE,
    "edibleSize":DOUBLE,        //What size food/objects/fish can fit in this fish's mouth
    "lifeExpectancy":DOUBLE,
    "minWaterCurrent":INTEGER,  //0 - No water current, 1 - Low water current, 2 - Medium water current, 3 - High water current
    "maxWaterCurrent":INTEGER,
    "substrate":STRING ARRAY,
    "image":STRING,             //Name of the image file where the picture of the fish is stored
    "minSwimLevel":INTEGER,     //Where the fish swims in the tank. 0 - Bottom of the tank, 1 - middle of the tank, 2 - top of the tank
    "maxSwimLevel":INTEGER,
    "finNipper":BOOLEAN,        //True if fish is likely to nip the fins of long-finned fish
    "longFins":BOOLEAN,         
    "aggressive":BOOLEAN,       
    "hardy":BOOLEAN,            //True if the fish will be able to withstand aggressive fish
    "territorial":BOOLEAN,      
    "minPopulation":INTEGER,    //Minimum amount of fish that can be kept in one tank
    "maxPopulation":INTEGER,    //Maximum amount of fish that can be kept in one tank
    "fast":BOOLEAN             

The format to add a new disease is:

    "name":STRING,
    "alias":STRING,
    "symptoms":STRING ARRAY,
    "causes":STRING ARRAY,
    "prevention":STRING ARRAY,
    "treatment":STRING ARRAY

All artwork featured in the application is created by me. 
