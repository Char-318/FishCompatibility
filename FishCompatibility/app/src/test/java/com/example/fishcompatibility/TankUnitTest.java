package com.example.fishcompatibility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TankUnitTest {
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

    @AfterClass
    public static void clear() {
        fishes = null;
    }
}
