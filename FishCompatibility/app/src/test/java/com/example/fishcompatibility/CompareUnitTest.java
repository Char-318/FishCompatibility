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

        assertTrue("goldfish-goldfish", goldfish.areFishCompatible(goldfish).getIsComp());
        assertFalse("goldfish-fancy Goldfish", goldfish.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("goldfish-endler guppy", goldfish.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("goldfish-hillstream loach", goldfish.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("goldfish-weather loach", goldfish.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("goldfish-betta", goldfish.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("goldfish-glass catfish", goldfish.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("goldfish-pleco", goldfish.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("goldfish-bronze corydora", goldfish.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("goldfish-molly", goldfish.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("goldfish-danio", goldfish.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("goldfish-swordtail", goldfish.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("goldfish-gourami", goldfish.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("goldfish-dwarf cichlid", goldfish.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("goldfish-angelfish", goldfish.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("goldfish-platy", goldfish.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void fancyGoldfishCompare() {
        Fish fancyGoldfish = fishes[1];

        assertFalse("fancy goldfish-goldfish", fancyGoldfish.areFishCompatible(fishes[0]).getIsComp());
        assertTrue("fancy goldfish-fancy goldfish", fancyGoldfish.areFishCompatible(fancyGoldfish).getIsComp());
        assertFalse("fancy goldfish-endler guppy", fancyGoldfish.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("fancy goldfish-hillstream loach", fancyGoldfish.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("fancy goldfish-weather loach", fancyGoldfish.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("fancy goldfish-betta", fancyGoldfish.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("fancy goldfish-glass catfish", fancyGoldfish.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("fancy goldfish-pleco", fancyGoldfish.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("fancy goldfish-bronze corydora", fancyGoldfish.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("fancy goldfish-molly", fancyGoldfish.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("fancy goldfish-danio", fancyGoldfish.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("fancy goldfish-swordtail", fancyGoldfish.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("fancy goldfish-gourami", fancyGoldfish.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("fancy goldfish-dwarf cichlid", fancyGoldfish.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("fancy goldfish-angelfish", fancyGoldfish.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("fancy goldfish-platy", fancyGoldfish.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void endlerCompare() {
        Fish endler = fishes[2];

        assertFalse("endler guppy-goldfish", endler.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("endler guppy-fancy goldfish", endler.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("endler guppy-endler guppy", endler.areFishCompatible(endler).getIsComp());
        assertFalse("endler guppy-hillstream loach", endler.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("endler guppy-weather loach", endler.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("endler guppy-betta", endler.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("endler guppy-glass catfish", endler.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("endler guppy-pleco", endler.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("endler guppy-bronze corydora", endler.areFishCompatible(fishes[8]).getIsComp());
        assertTrue("endler guppy-molly", endler.areFishCompatible(fishes[9]).getIsComp());
        assertTrue("endler guppy-danio", endler.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("endler guppy-swordtail", endler.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("endler guppy-gourami", endler.areFishCompatible(fishes[12]).getIsComp());
        assertTrue("endler guppy-dwarf cichlid", endler.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("endler guppy-angelfish", endler.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("endler guppy-platy", endler.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void hillstreamCompare() {
        Fish hillstream = fishes[3];

        assertFalse("hillstream loach-goldfish", hillstream.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("hillstream loach-fancy goldfish", hillstream.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("hillstream loach-endler guppy", hillstream.areFishCompatible(fishes[2]).getIsComp());
        assertTrue("hillstream loach-hillstream loach", hillstream.areFishCompatible(hillstream).getIsComp());
        assertFalse("hillstream loach-weather loach", hillstream.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("hillstream loach-betta", hillstream.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("hillstream loach-glass catfish", hillstream.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("hillstream loach-pleco", hillstream.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("hillstream loach-bronze corydora", hillstream.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("hillstream loach-molly", hillstream.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("hillstream loach-danio", hillstream.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("hillstream loach-swordtail", hillstream.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("hillstream loach-gourami", hillstream.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("hillstream loach-dwarf cichlid", hillstream.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("hillstream loach-angelfish", hillstream.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("hillstream loach-platy", hillstream.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void weatherCompare() {
        Fish weather = fishes[4];

        assertFalse("weather loach-goldfish", weather.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("weather loach-fancy goldfish", weather.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("weather loach-endler guppy", weather.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("weather loach-hillstream loach", weather.areFishCompatible(fishes[3]).getIsComp());
        assertTrue("weather loach-weather loach", weather.areFishCompatible(weather).getIsComp());
        assertFalse("weather loach-betta", weather.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("weather loach-glass catfish", weather.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("weather loach-pleco", weather.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("weather loach-bronze corydora", weather.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("weather loach-molly", weather.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("weather loach-danio", weather.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("weather loach-swordtail", weather.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("weather loach-gourami", weather.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("weather loach-dwarf cichlid", weather.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("weather loach-angelfish", weather.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("weather loach-platy", weather.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void bettaCompare() {
        Fish betta = fishes[5];

        assertFalse("betta-goldfish", betta.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("betta-fancy goldfish", betta.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("betta-endler guppy", betta.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("betta-hillstream loach", betta.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("betta-weather loach", betta.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("betta-betta", betta.areFishCompatible(betta).getIsComp());
        assertFalse("betta-glass catfish", betta.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("betta-pleco", betta.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("betta-bronze corydora", betta.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("betta-molly", betta.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("betta-danio", betta.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("betta-swordtail", betta.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("betta-gourami", betta.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("betta-dwarf cichlid", betta.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("betta-angelfish", betta.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("betta-platy", betta.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void glassCompare() {
        Fish glass = fishes[6];

        assertFalse("glass catfish-goldfish", glass.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("glass catfish-fancy goldfish", glass.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("glass catfish-endler guppy", glass.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("glass catfish-hillstream loach", glass.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("glass catfish-weather loach", glass.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("glass catfish-betta", glass.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("glass catfish-glass catfish", glass.areFishCompatible(glass).getIsComp());
        assertTrue("glass catfish-pleco", glass.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("glass catfish-bronze corydora", glass.areFishCompatible(fishes[8]).getIsComp());
        assertTrue("glass catfish-molly", glass.areFishCompatible(fishes[9]).getIsComp());
        assertTrue("glass catfish-danio", glass.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("glass catfish-swordtail", glass.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("glass catfish-gourami", glass.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("glass catfish-dwarf cichlid", glass.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("glass catfish-angelfish", glass.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("glass catfish-platy", glass.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void plecoCompare() {
        Fish pleco = fishes[7];

        assertFalse("pleco-goldfish", pleco.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("pleco-fancy goldfish", pleco.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("pleco-endler guppy", pleco.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("pleco-hillstream loach", pleco.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("pleco-weather loach", pleco.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("pleco-betta", pleco.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("pleco-glass catfish", pleco.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("pleco-pleco", pleco.areFishCompatible(pleco).getIsComp());
        assertFalse("pleco-bronze corydora", pleco.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("pleco-molly", pleco.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("pleco-danio", pleco.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("pleco-swordtail", pleco.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("pleco-gourami", pleco.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("pleco-dwarf cichlid", pleco.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("pleco-angelfish", pleco.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("pleco-platy", pleco.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void coryCompare() {
        Fish cory = fishes[8];

        assertFalse("bronze corydora-goldfish", cory.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("bronze corydora-fancy goldfish", cory.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("bronze corydora-endler guppy", cory.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("bronze corydora-hillstream loach", cory.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("bronze corydora-weather loach", cory.areFishCompatible(fishes[4]).getIsComp());
        assertTrue("bronze corydora-betta", cory.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("bronze corydora-glass catfish", cory.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("bronze corydora-pleco", cory.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("bronze corydora-bronze corydora", cory.areFishCompatible(cory).getIsComp());
        assertTrue("bronze corydora-molly", cory.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("bronze corydora-danio", cory.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("bronze corydora-swordtail", cory.areFishCompatible(fishes[11]).getIsComp());
        assertTrue("bronze corydora-gourami", cory.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("bronze corydora-dwarf cichlid", cory.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("bronze corydora-angelfish", cory.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("bronze corydora-platy", cory.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void mollyCompare() {
        Fish molly = fishes[9];

        assertFalse("molly-goldfish", molly.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("molly-fancy goldfish", molly.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("molly-endler guppy", molly.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("molly-hillstream loach", molly.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("molly-weather loach", molly.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("molly-betta", molly.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("molly-glass catfish", molly.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("molly-pleco", molly.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("molly-bronze corydora", molly.areFishCompatible(fishes[8]).getIsComp());
        assertTrue("molly-molly", molly.areFishCompatible(molly).getIsComp());
        assertFalse("molly-danio", molly.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("molly-swordtail", molly.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("molly-gourami", molly.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("molly-dwarf cichlid", molly.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("molly-angelfish", molly.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("molly-platy", molly.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void danioCompare() {
        Fish danio = fishes[10];

        assertFalse("danio-goldfish", danio.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("danio-fancy goldfish", danio.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("danio-endler guppy", danio.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("danio-hillstream loach", danio.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("danio-weather loach", danio.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("danio-betta", danio.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("danio-glass catfish", danio.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("danio-pleco", danio.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("danio-bronze corydora", danio.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("danio-molly", danio.areFishCompatible(fishes[9]).getIsComp());
        assertTrue("danio-danio", danio.areFishCompatible(danio).getIsComp());
        assertTrue("danio-swordtail", danio.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("danio-gourami", danio.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("danio-dwarf cichlid", danio.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("danio-angelfish", danio.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("danio-platy", danio.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void swordtailCompare() {
        Fish swordtail = fishes[11];

        assertFalse("swordtail-goldfish", swordtail.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("swordtail-fancy goldfish", swordtail.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("swordtail-endler guppy", swordtail.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("swordtail-hillstream loach", swordtail.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("swordtail-weather loach", swordtail.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("swordtail-betta", swordtail.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("swordtail-glass catfish", swordtail.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("swordtail-pleco", swordtail.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("swordtail-bronze corydora", swordtail.areFishCompatible(fishes[8]).getIsComp());
        assertTrue("swordtail-molly", swordtail.areFishCompatible(fishes[9]).getIsComp());
        assertTrue("swordtail-danio", swordtail.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("swordtail-swordtail", swordtail.areFishCompatible(swordtail).getIsComp());
        assertFalse("swordtail-gourami", swordtail.areFishCompatible(fishes[12]).getIsComp());
        assertTrue("swordtail-dwarf cichlid", swordtail.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("swordtail-angelfish", swordtail.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("swordtail-platy", swordtail.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void gouramiCompare() {
        Fish gourami = fishes[12];

        assertFalse("gourami-goldfish", gourami.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("gourami-fancy goldfish", gourami.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("gourami-endler guppy", gourami.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("gourami-hillstream loach", gourami.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("gourami-weather loach", gourami.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("gourami-betta", gourami.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("gourami-glass catfish", gourami.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("gourami-pleco", gourami.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("gourami-bronze corydora", gourami.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("gourami-molly", gourami.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("gourami-danio", gourami.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("gourami-swordtail", gourami.areFishCompatible(fishes[11]).getIsComp());
        assertTrue("gourami-gourami", gourami.areFishCompatible(gourami).getIsComp());
        assertFalse("gourami-dwarf cichlid", gourami.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("gourami-angelfish", gourami.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("gourami-platy", gourami.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void cichlidCompare() {
        Fish cichlid = fishes[13];

        assertFalse("dwarf cichlid-goldfish", cichlid.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("dwarf cichlid-fancy goldfish", cichlid.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("dwarf cichlid-endler guppy", cichlid.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("dwarf cichlid-hillstream loach", cichlid.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("dwarf cichlid-weather loach", cichlid.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("dwarf cichlid-betta", cichlid.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("dwarf cichlid-glass catfish", cichlid.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("dwarf cichlid-pleco", cichlid.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("dwarf cichlid-bronze corydora", cichlid.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("dwarf cichlid-molly", cichlid.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("dwarf cichlid-danio", cichlid.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("dwarf cichlid-swordtail", cichlid.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("dwarf cichlid-gourami", cichlid.areFishCompatible(fishes[12]).getIsComp());
        assertTrue("dwarf cichlid-dwarf cichlid", cichlid.areFishCompatible(cichlid).getIsComp());
        assertFalse("dwarf cichlid-angelfish", cichlid.areFishCompatible(fishes[14]).getIsComp());
        assertFalse("dwarf cichlid-platy", cichlid.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void angelfishCompare() {
        Fish angelfish = fishes[14];

        assertFalse("angelfish-goldfish", angelfish.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("angelfish-fancy goldfish", angelfish.areFishCompatible(fishes[1]).getIsComp());
        assertFalse("angelfish-endler guppy", angelfish.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("angelfish-hillstream loach", angelfish.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("angelfish-weather loach", angelfish.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("angelfish-betta", angelfish.areFishCompatible(fishes[5]).getIsComp());
        assertFalse("angelfish-glass catfish", angelfish.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("angelfish-pleco", angelfish.areFishCompatible(fishes[7]).getIsComp());
        assertFalse("angelfish-bronze corydora", angelfish.areFishCompatible(fishes[8]).getIsComp());
        assertFalse("angelfish-molly", angelfish.areFishCompatible(fishes[9]).getIsComp());
        assertFalse("angelfish-danio", angelfish.areFishCompatible(fishes[10]).getIsComp());
        assertFalse("angelfish-swordtail", angelfish.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("angelfish-gourami", angelfish.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("angelfish-dwarf cichlid", angelfish.areFishCompatible(fishes[13]).getIsComp());
        assertTrue("angelfish-angelfish", angelfish.areFishCompatible(angelfish).getIsComp());
        assertFalse("angelfish-platy", angelfish.areFishCompatible(fishes[15]).getIsComp());
    }

    @Test
    public void platyCompare() {
        Fish platy = fishes[15];

        assertTrue("platy-goldfish", platy.areFishCompatible(fishes[0]).getIsComp());
        assertFalse("platy-fancy goldfish", platy.areFishCompatible(fishes[1]).getIsComp());
        assertTrue("platy-endler guppy", platy.areFishCompatible(fishes[2]).getIsComp());
        assertFalse("platy-hillstream loach", platy.areFishCompatible(fishes[3]).getIsComp());
        assertFalse("platy-weather loach", platy.areFishCompatible(fishes[4]).getIsComp());
        assertFalse("platy-betta", platy.areFishCompatible(fishes[5]).getIsComp());
        assertTrue("platy-glass catfish", platy.areFishCompatible(fishes[6]).getIsComp());
        assertFalse("platy-pleco", platy.areFishCompatible(fishes[7]).getIsComp());
        assertTrue("platy-bronze corydora", platy.areFishCompatible(fishes[8]).getIsComp());
        assertTrue("platy-molly", platy.areFishCompatible(fishes[9]).getIsComp());
        assertTrue("platy-danio", platy.areFishCompatible(fishes[10]).getIsComp());
        assertTrue("platy-swordtail", platy.areFishCompatible(fishes[11]).getIsComp());
        assertFalse("platy-gourami", platy.areFishCompatible(fishes[12]).getIsComp());
        assertFalse("platy-dwarf cichlid", platy.areFishCompatible(fishes[13]).getIsComp());
        assertFalse("platy-angelfish", platy.areFishCompatible(fishes[14]).getIsComp());
        assertTrue("platy-platy", platy.areFishCompatible(platy).getIsComp());
    }

    @AfterClass
    public static void clear() {
        fishes = null;
    }
}