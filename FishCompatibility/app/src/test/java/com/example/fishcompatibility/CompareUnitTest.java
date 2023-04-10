package com.example.fishcompatibility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareUnitTest {

    private static Fish[] fishes;

    /**
     * Run before all tests to populate fish array
     */
    @BeforeClass
    public static void setup() {
        // Aliases and food type not needed to calculate if comparable
        String[] emptyArray = {""};
        Fish goldfish = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel"}, 0, 2, 1,
                1, 2, 0, 10.0, 21.0, 6.0,
                8.0, 5.0, 19.0, 6.0, 16.0,
                25.0, 7.0, 15.5, false, false,
                false, true, false, true);
        Fish fancyGoldfish = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel"}, 0, 0, 1,
                1, 2, 0, 15.0, 23.0, 6.5,
                8.5, 8.0, 18.0, 5.0, 15.0,
                20.0, 7.0, 12.5, false, true,
                false, true, false, false);
        Fish endlerGuppy = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 0, 2, 0,
                2, 3, 0, 22.0, 28.0, 7.0,
                8.0, 8.0, 18.0, 5.0, 15.0,
                2.5, 0.0, 2.5, false, false,
                false, true, false, true);
        Fish hillstreamLoach = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Sand", "Fine gravel"}, 2, 3,
                0, 0, 6, 0, 18.0, 24.0,
                6.5, 8.0, 4.0, 12.0, 3.0,
                10.0, 6.0, 1.0, 9.0, false,
                true, false, true, true, true);
        Fish weatherLoach = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Fine gravel", "Sand"}, 0, 1,
                1, 1, 2, 0, 15.0, 23.0,
                6.5, 8.5, 8.0, 18.0, 5.0,
                15.0, 20.0, 7.0, 12.5, false,
                true, false, true, false, false);
        Fish betta = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 0, 1, 1,
                2, 1, 1, 20.0, 28.0, 6.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                7.0, 2.0, 3.5, true, true,
                true, false, true, false);
        Fish glassCatfish = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Fine gravel", "Sand"}, 1, 2,
                1, 1, 5, 0, 22.0, 27.0,
                6.0, 8.0, 4.0, 18.0, 3.0,
                15.0, 12.5, 3.0, 7.5, false,
                false, false, false, false, true);
        Fish pleco = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Fine gravel", "Sand"}, 2, 3,
                0, 0, 1, 1, 22.0, 27.0,
                6.0, 8.0, 4.0, 18.0, 3.0,
                15.0, 38.0, 0.0, 12.5, false,
                true, false, true, true, false);
        Fish bronzeCory = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Fine gravel", "Sand"}, 0, 1,
                0, 0, 5, 0, 17.0, 27.0,
                6.0, 8.0, 4.0, 12.0, 3.0,
                10.0, 6.0, 0.0, 10.0, false,
                false, false, true, false, true);
        Fish molly = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 0, 1, 0,
                2, 3, 0, 20.0, 28.0, 7.0,
                8.0, 8.0, 18.0, 5.0, 15.0,
                10.0, 0.0, 3.5, true, false,
                false, true, true, true);
        Fish danio = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 2, 2, 1,
                2, 5, 0, 17.0, 27.0, 6.5,
                8.0, 4.0, 12.0, 3.0, 10.0,
                5.0, 1.0, 3.5, true, false,
                false, true, true, true);
        Fish swordtail = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 1, 2, 0,
                2, 3, 0, 22.0, 27.0, 7.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                10.0, 0.0, 4.0, false, false,
                false, true, true, true);
        Fish gourami = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 0, 0, 1,
                2, 3, 0, 20.0, 28.0, 6.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                13.5, 4.0, 3.5, true, true,
                true, false, true, false);
        Fish dwarfCichlid = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 1, 2, 0,
                0, 2, 0, 22.0, 27.0, 6.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                7.5, 2.0, 7.5, true, true,
                true, true, true, true);
        Fish angelfish = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Sand", "Mud"}, 1, 2, 1,
                1, 2, 0, 25.0, 28.0, 6.8,
                7.0, 4.0, 12.0, 3.0, 10.0,
                9.0, 2.5, 11.0, true, true,
                true, true, true, false);
        Fish platy = new Fish("", "", "", "", emptyArray,
                emptyArray, new String[]{"Gravel", "Sand"}, 1, 2, 1,
                1, 3, 0, 17.0, 27.0, 7.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                7.0, 1.0, 3.5, true, false,
                false, true, false, true);

        fishes = new Fish[]{goldfish, fancyGoldfish, endlerGuppy, hillstreamLoach, weatherLoach,
                betta, glassCatfish, pleco, bronzeCory, molly, danio, swordtail, gourami,
                dwarfCichlid, angelfish, platy};
    }

    @Test
    public void goldfishCompare() {
        Fish goldfish = fishes[0];

        assertTrue("goldfish-goldfish", goldfish.areFishCompatible(goldfish));
        assertFalse("goldfish-fancy Goldfish", goldfish.areFishCompatible(fishes[1]));
        assertFalse("goldfish-endler guppy", goldfish.areFishCompatible(fishes[2]));
        assertFalse("goldfish-hillstream loach", goldfish.areFishCompatible(fishes[3]));
        assertFalse("goldfish-weather loach", goldfish.areFishCompatible(fishes[4]));
        assertFalse("goldfish-betta", goldfish.areFishCompatible(fishes[5]));
        assertFalse("goldfish-glass catfish", goldfish.areFishCompatible(fishes[6]));
        assertFalse("goldfish-pleco", goldfish.areFishCompatible(fishes[7]));
        assertFalse("goldfish-bronze corydora", goldfish.areFishCompatible(fishes[8]));
        assertFalse("goldfish-molly", goldfish.areFishCompatible(fishes[9]));
        assertFalse("goldfish-danio", goldfish.areFishCompatible(fishes[10]));
        assertFalse("goldfish-swordtail", goldfish.areFishCompatible(fishes[11]));
        assertFalse("goldfish-gourami", goldfish.areFishCompatible(fishes[12]));
        assertFalse("goldfish-dwarf cichlid", goldfish.areFishCompatible(fishes[13]));
        assertFalse("goldfish-angelfish", goldfish.areFishCompatible(fishes[14]));
        assertTrue("goldfish-platy", goldfish.areFishCompatible(fishes[15]));
    }

    @Test
    public void fancyGoldfishCompare() {
        Fish fancyGoldfish = fishes[1];

        assertFalse("fancy goldfish-goldfish", fancyGoldfish.areFishCompatible(fishes[0]));
        assertTrue("fancy goldfish-fancy goldfish", fancyGoldfish.areFishCompatible(fancyGoldfish));
        assertFalse("fancy goldfish-endler guppy", fancyGoldfish.areFishCompatible(fishes[2]));
        assertFalse("fancy goldfish-hillstream loach", fancyGoldfish.areFishCompatible(fishes[3]));
        assertFalse("fancy goldfish-weather loach", fancyGoldfish.areFishCompatible(fishes[4]));
        assertFalse("fancy goldfish-betta", fancyGoldfish.areFishCompatible(fishes[5]));
        assertFalse("fancy goldfish-glass catfish", fancyGoldfish.areFishCompatible(fishes[6]));
        assertFalse("fancy goldfish-pleco", fancyGoldfish.areFishCompatible(fishes[7]));
        assertFalse("fancy goldfish-bronze corydora", fancyGoldfish.areFishCompatible(fishes[8]));
        assertFalse("fancy goldfish-molly", fancyGoldfish.areFishCompatible(fishes[9]));
        assertFalse("fancy goldfish-danio", fancyGoldfish.areFishCompatible(fishes[10]));
        assertFalse("fancy goldfish-swordtail", fancyGoldfish.areFishCompatible(fishes[11]));
        assertFalse("fancy goldfish-gourami", fancyGoldfish.areFishCompatible(fishes[12]));
        assertFalse("fancy goldfish-dwarf cichlid", fancyGoldfish.areFishCompatible(fishes[13]));
        assertFalse("fancy goldfish-angelfish", fancyGoldfish.areFishCompatible(fishes[14]));
        assertFalse("fancy goldfish-platy", fancyGoldfish.areFishCompatible(fishes[15]));
    }

    @Test
    public void endlerCompare() {
        Fish endler = fishes[2];

        assertFalse("endler guppy-goldfish", endler.areFishCompatible(fishes[0]));
        assertFalse("endler guppy-fancy goldfish", endler.areFishCompatible(fishes[1]));
        assertTrue("endler guppy-endler guppy", endler.areFishCompatible(endler));
        assertFalse("endler guppy-hillstream loach", endler.areFishCompatible(fishes[3]));
        assertFalse("endler guppy-weather loach", endler.areFishCompatible(fishes[4]));
        assertFalse("endler guppy-betta", endler.areFishCompatible(fishes[5]));
        assertFalse("endler guppy-glass catfish", endler.areFishCompatible(fishes[6]));
        assertFalse("endler guppy-pleco", endler.areFishCompatible(fishes[7]));
        assertTrue("endler guppy-bronze corydora", endler.areFishCompatible(fishes[8]));
        assertTrue("endler guppy-molly", endler.areFishCompatible(fishes[9]));
        assertTrue("endler guppy-danio", endler.areFishCompatible(fishes[10]));
        assertTrue("endler guppy-swordtail", endler.areFishCompatible(fishes[11]));
        assertFalse("endler guppy-gourami", endler.areFishCompatible(fishes[12]));
        assertTrue("endler guppy-dwarf cichlid", endler.areFishCompatible(fishes[13]));
        assertFalse("endler guppy-angelfish", endler.areFishCompatible(fishes[14]));
        assertTrue("endler guppy-platy", endler.areFishCompatible(fishes[15]));
    }

    @Test
    public void hillstreamCompare() {
        Fish hillstream = fishes[3];

        assertFalse("hillstream loach-goldfish", hillstream.areFishCompatible(fishes[0]));
        assertFalse("hillstream loach-fancy goldfish", hillstream.areFishCompatible(fishes[1]));
        assertFalse("hillstream loach-endler guppy", hillstream.areFishCompatible(fishes[2]));
        assertTrue("hillstream loach-hillstream loach", hillstream.areFishCompatible(hillstream));
        assertFalse("hillstream loach-weather loach", hillstream.areFishCompatible(fishes[4]));
        assertFalse("hillstream loach-betta", hillstream.areFishCompatible(fishes[5]));
        assertFalse("hillstream loach-glass catfish", hillstream.areFishCompatible(fishes[6]));
        assertFalse("hillstream loach-pleco", hillstream.areFishCompatible(fishes[7]));
        assertFalse("hillstream loach-bronze corydora", hillstream.areFishCompatible(fishes[8]));
        assertFalse("hillstream loach-molly", hillstream.areFishCompatible(fishes[9]));
        assertFalse("hillstream loach-danio", hillstream.areFishCompatible(fishes[10]));
        assertFalse("hillstream loach-swordtail", hillstream.areFishCompatible(fishes[11]));
        assertFalse("hillstream loach-gourami", hillstream.areFishCompatible(fishes[12]));
        assertFalse("hillstream loach-dwarf cichlid", hillstream.areFishCompatible(fishes[13]));
        assertFalse("hillstream loach-angelfish", hillstream.areFishCompatible(fishes[14]));
        assertFalse("hillstream loach-platy", hillstream.areFishCompatible(fishes[15]));
    }

    @Test
    public void weatherCompare() {
        Fish weather = fishes[4];

        assertFalse("weather loach-goldfish", weather.areFishCompatible(fishes[0]));
        assertFalse("weather loach-fancy goldfish", weather.areFishCompatible(fishes[1]));
        assertFalse("weather loach-endler guppy", weather.areFishCompatible(fishes[2]));
        assertFalse("weather loach-hillstream loach", weather.areFishCompatible(fishes[3]));
        assertTrue("weather loach-weather loach", weather.areFishCompatible(weather));
        assertFalse("weather loach-betta", weather.areFishCompatible(fishes[5]));
        assertFalse("weather loach-glass catfish", weather.areFishCompatible(fishes[6]));
        assertFalse("weather loach-pleco", weather.areFishCompatible(fishes[7]));
        assertFalse("weather loach-bronze corydora", weather.areFishCompatible(fishes[8]));
        assertFalse("weather loach-molly", weather.areFishCompatible(fishes[9]));
        assertFalse("weather loach-danio", weather.areFishCompatible(fishes[10]));
        assertFalse("weather loach-swordtail", weather.areFishCompatible(fishes[11]));
        assertFalse("weather loach-gourami", weather.areFishCompatible(fishes[12]));
        assertFalse("weather loach-dwarf cichlid", weather.areFishCompatible(fishes[13]));
        assertFalse("weather loach-angelfish", weather.areFishCompatible(fishes[14]));
        assertFalse("weather loach-platy", weather.areFishCompatible(fishes[15]));
    }

    @Test
    public void bettaCompare() {
        Fish betta = fishes[5];

        assertFalse("betta-goldfish", betta.areFishCompatible(fishes[0]));
        assertFalse("betta-fancy goldfish", betta.areFishCompatible(fishes[1]));
        assertFalse("betta-endler guppy", betta.areFishCompatible(fishes[2]));
        assertFalse("betta-hillstream loach", betta.areFishCompatible(fishes[3]));
        assertFalse("betta-weather loach", betta.areFishCompatible(fishes[4]));
        assertFalse("betta-betta", betta.areFishCompatible(betta));
        assertFalse("betta-glass catfish", betta.areFishCompatible(fishes[6]));
        assertFalse("betta-pleco", betta.areFishCompatible(fishes[7]));
        assertTrue("betta-bronze corydora", betta.areFishCompatible(fishes[8]));
        assertFalse("betta-molly", betta.areFishCompatible(fishes[9]));
        assertFalse("betta-danio", betta.areFishCompatible(fishes[10]));
        assertFalse("betta-swordtail", betta.areFishCompatible(fishes[11]));
        assertFalse("betta-gourami", betta.areFishCompatible(fishes[12]));
        assertFalse("betta-dwarf cichlid", betta.areFishCompatible(fishes[13]));
        assertFalse("betta-angelfish", betta.areFishCompatible(fishes[14]));
        assertFalse("betta-platy", betta.areFishCompatible(fishes[15]));
    }

    @Test
    public void glassCompare() {
        Fish glass = fishes[6];

        assertFalse("glass catfish-goldfish", glass.areFishCompatible(fishes[0]));
        assertFalse("glass catfish-fancy goldfish", glass.areFishCompatible(fishes[1]));
        assertFalse("glass catfish-endler guppy", glass.areFishCompatible(fishes[2]));
        assertFalse("glass catfish-hillstream loach", glass.areFishCompatible(fishes[3]));
        assertFalse("glass catfish-weather loach", glass.areFishCompatible(fishes[4]));
        assertFalse("glass catfish-betta", glass.areFishCompatible(fishes[5]));
        assertTrue("glass catfish-glass catfish", glass.areFishCompatible(glass));
        assertTrue("glass catfish-pleco", glass.areFishCompatible(fishes[7]));
        assertTrue("glass catfish-bronze corydora", glass.areFishCompatible(fishes[8]));
        assertTrue("glass catfish-molly", glass.areFishCompatible(fishes[9]));
        assertTrue("glass catfish-danio", glass.areFishCompatible(fishes[10]));
        assertTrue("glass catfish-swordtail", glass.areFishCompatible(fishes[11]));
        assertFalse("glass catfish-gourami", glass.areFishCompatible(fishes[12]));
        assertFalse("glass catfish-dwarf cichlid", glass.areFishCompatible(fishes[13]));
        assertFalse("glass catfish-angelfish", glass.areFishCompatible(fishes[14]));
        assertTrue("glass catfish-platy", glass.areFishCompatible(fishes[15]));
    }

    @Test
    public void plecoCompare() {
        Fish pleco = fishes[7];

        assertFalse("pleco-goldfish", pleco.areFishCompatible(fishes[0]));
        assertFalse("pleco-fancy goldfish", pleco.areFishCompatible(fishes[1]));
        assertFalse("pleco-endler guppy", pleco.areFishCompatible(fishes[2]));
        assertFalse("pleco-hillstream loach", pleco.areFishCompatible(fishes[3]));
        assertFalse("pleco-weather loach", pleco.areFishCompatible(fishes[4]));
        assertFalse("pleco-betta", pleco.areFishCompatible(fishes[5]));
        assertTrue("pleco-glass catfish", pleco.areFishCompatible(fishes[6]));
        assertFalse("pleco-pleco", pleco.areFishCompatible(pleco));
        assertFalse("pleco-bronze corydora", pleco.areFishCompatible(fishes[8]));
        assertFalse("pleco-molly", pleco.areFishCompatible(fishes[9]));
        assertFalse("pleco-danio", pleco.areFishCompatible(fishes[10]));
        assertFalse("pleco-swordtail", pleco.areFishCompatible(fishes[11]));
        assertFalse("pleco-gourami", pleco.areFishCompatible(fishes[12]));
        assertFalse("pleco-dwarf cichlid", pleco.areFishCompatible(fishes[13]));
        assertFalse("pleco-angelfish", pleco.areFishCompatible(fishes[14]));
        assertFalse("pleco-platy", pleco.areFishCompatible(fishes[15]));
    }

    @Test
    public void coryCompare() {
        Fish cory = fishes[8];

        assertFalse("bronze corydora-goldfish", cory.areFishCompatible(fishes[0]));
        assertFalse("bronze corydora-fancy goldfish", cory.areFishCompatible(fishes[1]));
        assertTrue("bronze corydora-endler guppy", cory.areFishCompatible(fishes[2]));
        assertFalse("bronze corydora-hillstream loach", cory.areFishCompatible(fishes[3]));
        assertFalse("bronze corydora-weather loach", cory.areFishCompatible(fishes[4]));
        assertTrue("bronze corydora-betta", cory.areFishCompatible(fishes[5]));
        assertTrue("bronze corydora-glass catfish", cory.areFishCompatible(fishes[6]));
        assertFalse("bronze corydora-pleco", cory.areFishCompatible(fishes[7]));
        assertTrue("bronze corydora-bronze corydora", cory.areFishCompatible(cory));
        assertTrue("bronze corydora-molly", cory.areFishCompatible(fishes[9]));
        assertFalse("bronze corydora-danio", cory.areFishCompatible(fishes[10]));
        assertTrue("bronze corydora-swordtail", cory.areFishCompatible(fishes[11]));
        assertTrue("bronze corydora-gourami", cory.areFishCompatible(fishes[12]));
        assertFalse("bronze corydora-dwarf cichlid", cory.areFishCompatible(fishes[13]));
        assertFalse("bronze corydora-angelfish", cory.areFishCompatible(fishes[14]));
        assertTrue("bronze corydora-platy", cory.areFishCompatible(fishes[15]));
    }

    @Test
    public void mollyCompare() {
        Fish molly = fishes[9];

        assertFalse("molly-goldfish", molly.areFishCompatible(fishes[0]));
        assertFalse("molly-fancy goldfish", molly.areFishCompatible(fishes[1]));
        assertTrue("molly-endler guppy", molly.areFishCompatible(fishes[2]));
        assertFalse("molly-hillstream loach", molly.areFishCompatible(fishes[3]));
        assertFalse("molly-weather loach", molly.areFishCompatible(fishes[4]));
        assertFalse("molly-betta", molly.areFishCompatible(fishes[5]));
        assertTrue("molly-glass catfish", molly.areFishCompatible(fishes[6]));
        assertFalse("molly-pleco", molly.areFishCompatible(fishes[7]));
        assertTrue("molly-bronze corydora", molly.areFishCompatible(fishes[8]));
        assertTrue("molly-molly", molly.areFishCompatible(molly));
        assertFalse("molly-danio", molly.areFishCompatible(fishes[10]));
        assertTrue("molly-swordtail", molly.areFishCompatible(fishes[11]));
        assertFalse("molly-gourami", molly.areFishCompatible(fishes[12]));
        assertFalse("molly-dwarf cichlid", molly.areFishCompatible(fishes[13]));
        assertFalse("molly-angelfish", molly.areFishCompatible(fishes[14]));
        assertTrue("molly-platy", molly.areFishCompatible(fishes[15]));
    }

    @Test
    public void danioCompare() {
        Fish danio = fishes[10];

        assertFalse("danio-goldfish", danio.areFishCompatible(fishes[0]));
        assertFalse("danio-fancy goldfish", danio.areFishCompatible(fishes[1]));
        assertTrue("danio-endler guppy", danio.areFishCompatible(fishes[2]));
        assertFalse("danio-hillstream loach", danio.areFishCompatible(fishes[3]));
        assertFalse("danio-weather loach", danio.areFishCompatible(fishes[4]));
        assertFalse("danio-betta", danio.areFishCompatible(fishes[5]));
        assertTrue("danio-glass catfish", danio.areFishCompatible(fishes[6]));
        assertFalse("danio-pleco", danio.areFishCompatible(fishes[7]));
        assertFalse("danio-bronze corydora", danio.areFishCompatible(fishes[8]));
        assertFalse("danio-molly", danio.areFishCompatible(fishes[9]));
        assertTrue("danio-danio", danio.areFishCompatible(danio));
        assertTrue("danio-swordtail", danio.areFishCompatible(fishes[11]));
        assertFalse("danio-gourami", danio.areFishCompatible(fishes[12]));
        assertFalse("danio-dwarf cichlid", danio.areFishCompatible(fishes[13]));
        assertFalse("danio-angelfish", danio.areFishCompatible(fishes[14]));
        assertTrue("danio-platy", danio.areFishCompatible(fishes[15]));
    }

    @Test
    public void swordtailCompare() {
        Fish swordtail = fishes[11];

        assertFalse("swordtail-goldfish", swordtail.areFishCompatible(fishes[0]));
        assertFalse("swordtail-fancy goldfish", swordtail.areFishCompatible(fishes[1]));
        assertTrue("swordtail-endler guppy", swordtail.areFishCompatible(fishes[2]));
        assertFalse("swordtail-hillstream loach", swordtail.areFishCompatible(fishes[3]));
        assertFalse("swordtail-weather loach", swordtail.areFishCompatible(fishes[4]));
        assertFalse("swordtail-betta", swordtail.areFishCompatible(fishes[5]));
        assertTrue("swordtail-glass catfish", swordtail.areFishCompatible(fishes[6]));
        assertFalse("swordtail-pleco", swordtail.areFishCompatible(fishes[7]));
        assertTrue("swordtail-bronze corydora", swordtail.areFishCompatible(fishes[8]));
        assertTrue("swordtail-molly", swordtail.areFishCompatible(fishes[9]));
        assertTrue("swordtail-danio", swordtail.areFishCompatible(fishes[10]));
        assertTrue("swordtail-swordtail", swordtail.areFishCompatible(swordtail));
        assertFalse("swordtail-gourami", swordtail.areFishCompatible(fishes[12]));
        assertTrue("swordtail-dwarf cichlid", swordtail.areFishCompatible(fishes[13]));
        assertFalse("swordtail-angelfish", swordtail.areFishCompatible(fishes[14]));
        assertTrue("swordtail-platy", swordtail.areFishCompatible(fishes[15]));
    }

    @Test
    public void gouramiCompare() {
        Fish gourami = fishes[12];

        assertFalse("gourami-goldfish", gourami.areFishCompatible(fishes[0]));
        assertFalse("gourami-fancy goldfish", gourami.areFishCompatible(fishes[1]));
        assertFalse("gourami-endler guppy", gourami.areFishCompatible(fishes[2]));
        assertFalse("gourami-hillstream loach", gourami.areFishCompatible(fishes[3]));
        assertFalse("gourami-weather loach", gourami.areFishCompatible(fishes[4]));
        assertFalse("gourami-betta", gourami.areFishCompatible(fishes[5]));
        assertFalse("gourami-glass catfish", gourami.areFishCompatible(fishes[6]));
        assertFalse("gourami-pleco", gourami.areFishCompatible(fishes[7]));
        assertTrue("gourami-bronze corydora", gourami.areFishCompatible(fishes[8]));
        assertFalse("gourami-molly", gourami.areFishCompatible(fishes[9]));
        assertFalse("gourami-danio", gourami.areFishCompatible(fishes[10]));
        assertFalse("gourami-swordtail", gourami.areFishCompatible(fishes[11]));
        assertTrue("gourami-gourami", gourami.areFishCompatible(gourami));
        assertFalse("gourami-dwarf cichlid", gourami.areFishCompatible(fishes[13]));
        assertFalse("gourami-angelfish", gourami.areFishCompatible(fishes[14]));
        assertFalse("gourami-platy", gourami.areFishCompatible(fishes[15]));
    }

    @Test
    public void cichlidCompare() {
        Fish cichlid = fishes[13];

        assertFalse("dwarf cichlid-goldfish", cichlid.areFishCompatible(fishes[0]));
        assertFalse("dwarf cichlid-fancy goldfish", cichlid.areFishCompatible(fishes[1]));
        assertTrue("dwarf cichlid-endler guppy", cichlid.areFishCompatible(fishes[2]));
        assertFalse("dwarf cichlid-hillstream loach", cichlid.areFishCompatible(fishes[3]));
        assertFalse("dwarf cichlid-weather loach", cichlid.areFishCompatible(fishes[4]));
        assertFalse("dwarf cichlid-betta", cichlid.areFishCompatible(fishes[5]));
        assertFalse("dwarf cichlid-glass catfish", cichlid.areFishCompatible(fishes[6]));
        assertFalse("dwarf cichlid-pleco", cichlid.areFishCompatible(fishes[7]));
        assertFalse("dwarf cichlid-bronze corydora", cichlid.areFishCompatible(fishes[8]));
        assertFalse("dwarf cichlid-molly", cichlid.areFishCompatible(fishes[9]));
        assertFalse("dwarf cichlid-danio", cichlid.areFishCompatible(fishes[10]));
        assertTrue("dwarf cichlid-swordtail", cichlid.areFishCompatible(fishes[11]));
        assertFalse("dwarf cichlid-gourami", cichlid.areFishCompatible(fishes[12]));
        assertTrue("dwarf cichlid-dwarf cichlid", cichlid.areFishCompatible(cichlid));
        assertFalse("dwarf cichlid-angelfish", cichlid.areFishCompatible(fishes[14]));
        assertFalse("dwarf cichlid-platy", cichlid.areFishCompatible(fishes[15]));
    }

    @Test
    public void angelfishCompare() {
        Fish angelfish = fishes[14];

        assertFalse("angelfish-goldfish", angelfish.areFishCompatible(fishes[0]));
        assertFalse("angelfish-fancy goldfish", angelfish.areFishCompatible(fishes[1]));
        assertFalse("angelfish-endler guppy", angelfish.areFishCompatible(fishes[2]));
        assertFalse("angelfish-hillstream loach", angelfish.areFishCompatible(fishes[3]));
        assertFalse("angelfish-weather loach", angelfish.areFishCompatible(fishes[4]));
        assertFalse("angelfish-betta", angelfish.areFishCompatible(fishes[5]));
        assertFalse("angelfish-glass catfish", angelfish.areFishCompatible(fishes[6]));
        assertFalse("angelfish-pleco", angelfish.areFishCompatible(fishes[7]));
        assertFalse("angelfish-bronze corydora", angelfish.areFishCompatible(fishes[8]));
        assertFalse("angelfish-molly", angelfish.areFishCompatible(fishes[9]));
        assertFalse("angelfish-danio", angelfish.areFishCompatible(fishes[10]));
        assertFalse("angelfish-swordtail", angelfish.areFishCompatible(fishes[11]));
        assertFalse("angelfish-gourami", angelfish.areFishCompatible(fishes[12]));
        assertFalse("angelfish-dwarf cichlid", angelfish.areFishCompatible(fishes[13]));
        assertTrue("angelfish-angelfish", angelfish.areFishCompatible(angelfish));
        assertFalse("angelfish-platy", angelfish.areFishCompatible(fishes[15]));
    }

    @Test
    public void platyCompare() {
        Fish platy = fishes[15];

        assertTrue("platy-goldfish", platy.areFishCompatible(fishes[0]));
        assertFalse("platy-fancy goldfish", platy.areFishCompatible(fishes[1]));
        assertTrue("platy-endler guppy", platy.areFishCompatible(fishes[2]));
        assertFalse("platy-hillstream loach", platy.areFishCompatible(fishes[3]));
        assertFalse("platy-weather loach", platy.areFishCompatible(fishes[4]));
        assertFalse("platy-betta", platy.areFishCompatible(fishes[5]));
        assertTrue("platy-glass catfish", platy.areFishCompatible(fishes[6]));
        assertFalse("platy-pleco", platy.areFishCompatible(fishes[7]));
        assertTrue("platy-bronze corydora", platy.areFishCompatible(fishes[8]));
        assertTrue("platy-molly", platy.areFishCompatible(fishes[9]));
        assertTrue("platy-danio", platy.areFishCompatible(fishes[10]));
        assertTrue("platy-swordtail", platy.areFishCompatible(fishes[11]));
        assertFalse("platy-gourami", platy.areFishCompatible(fishes[12]));
        assertFalse("platy-dwarf cichlid", platy.areFishCompatible(fishes[13]));
        assertFalse("platy-angelfish", platy.areFishCompatible(fishes[14]));
        assertTrue("platy-platy", platy.areFishCompatible(platy));
    }

    @AfterClass
    public static void clear() {
        fishes = null;
    }
}