package com.example.fishcompatibility;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class SearchFishUnitTest {
    private static Fish[] fishes;

    /**
     * Run before all tests to populate fish array
     */
    @BeforeClass
    public static void setup() {
        Fish goldfish = new Fish("Goldfish", "Carassius auratus", "Herbivore",
                "goldfish", new String[]{}, new String[]{"Goldfish flakes", "Goldfish pellets"},
                new String[]{"Gravel"}, 0, 2, 1, 1, 2,
                0, 10.0, 21.0, 6.0, 8.0, 5.0,
                19.0, 6.0, 16.0, 25.0, 7.0,
                15.5, false, false, false, true,
                false, true);
        Fish fancyGoldfish = new Fish("Fancy Goldfish", "Carassius auratus",
                "Omnivore", "fancy_goldfish", new String[]{"Fantail goldfish",
                "Blackmoor goldfish", "Black telescope", "Bubble eye goldfish", "Veiltail goldfish",
                "Lionhead goldfish", "Pearlscale goldfish", "Wakin goldfish"},
                new String[]{"Slow sinking food"}, new String[]{"Gravel"}, 0, 0,
                1, 1, 2, 0, 15.0, 23.0,
                6.5, 8.5, 8.0, 18.0, 5.0,
                15.0, 20.0, 7.0, 12.5, false, true,
                false, true, false, false);
        Fish endlerGuppy = new Fish("Endler Guppy", "Poecilia wingei", "Omnivore",
                "endler_guppy", new String[]{"Endler's livebearer", "Endler"},
                new String[]{"Algae flakes", "Algae granules"}, new String[]{"Gravel", "Sand"},
                0, 2, 0, 2, 3, 0, 22.0,
                28.0, 7.0, 8.0, 8.0, 18.0,
                5.0, 15.0, 2.5, 0.0, 2.5, false,
                false, false, true, false, true);
        Fish hillstreamLoach = new Fish("Hillstream Loach", "Balitoridae", "Omnivore",
                "hillstream_loach", new String[]{"River loach"},
                new String[]{"Sinking catfish pellets"}, new String[]{"Sand", "Fine gravel"},
                2, 3, 0, 0, 6, 0, 18.0,
                24.0, 6.5, 8.0, 4.0, 12.0,
                3.0, 10.0, 6.0, 1.0, 9.0, false,
                true, false, true, true, true);
        Fish weatherLoach = new Fish("Weather Loach", "Misgurnus Anguillicaudatus",
                "Omnivore", "weather_loach", new String[]{"Pond loach", "Dojo loach",
                "Oriental weatherloach", "Oriental weatherfish"},
                new String[]{"Sinking catfish pellets"}, new String[]{"Fine gravel", "Sand"},
                0, 1, 1, 1, 2, 0, 15.0,
                23.0, 6.5, 8.5, 8.0, 18.0,
                5.0, 15.0, 20.0, 7.0, 12.5, false,
                true, false, true, false, false);
        Fish betta = new Fish("Betta", "Betta splendens", "Omnivore",
                "betta", new String[]{"Siamese fighting fish"}, new String[]{"Betta flakes",
                "Betta granules"}, new String[]{"Gravel", "Sand"}, 0, 1, 1,
                2, 1, 1, 20.0, 28.0, 6.0,
                8.0, 4.0, 12.0, 3.0, 10.0,
                7.0, 2.0, 3.5, true, true,
                true, false, true, false);
        Fish glassCatfish = new Fish("Glass Catfish", "Kryptopterus vitreolus",
                "Omnivore", "glass_catfish", new String[]{"Ghost catfish", "Phantom catfish"},
                new String[]{"Flakes", "Pellets"}, new String[]{"Fine gravel", "Sand"}, 1,
                2, 1, 1, 5, 0, 22.0,
                27.0, 6.0, 8.0, 4.0, 18.0,
                3.0, 15.0, 12.5, 3.0, 7.5, false,
                false, false, false, false, true);
        Fish pleco = new Fish("Pleco", "Hypostomus plecostomus", "Herbivore",
                "pleco", new String[]{"Suckermouth catfish"},
                new String[]{"Sinking catfish pellets"}, new String[]{"Fine gravel", "Sand"}, 2,
                3, 0, 0, 1, 1, 22.0,
                27.0, 6.0, 8.0, 4.0, 18.0,
                3.0, 15.0, 38.0, 0.0, 12.5, false,
                true, false, true, true, false);
        Fish bronzeCory = new Fish("Bronze Corydora", "Corydoras aeneus", "Omnivore",
                "bronze_corydora", new String[]{"Bronze cory", "Green cory"},
                new String[]{"Sinking catfish pellets"}, new String[]{"Fine gravel", "Sand"},
                0, 1, 0, 0, 5, 0, 17.0,
                27.0, 6.0, 8.0, 4.0, 12.0,
                3.0, 10.0, 6.0, 0.0, 10.0, false,
                false, false, true, false, true);
        Fish molly = new Fish("Molly", "Poecilia sphenops", "Omnivore", "molly",
                new String[]{"Short-finned molly", "Common molly"}, new String[]{"Algae flakes",
                "Algae granules"}, new String[]{"Gravel", "Sand"}, 0, 1, 0,
                2, 3, 0, 20.0, 28.0, 7.0,
                8.0, 8.0, 18.0, 5.0, 15.0,
                10.0, 0.0, 3.5, true, false,
                false, true, true, true);
        Fish danio = new Fish("Danio", "Danio", "Omnivore", "danio",
                new String[]{}, new String[]{"Flakes", "Granules"}, new String[]{"Gravel", "Sand"},
                2, 2, 1, 2, 5, 0, 17.0,
                27.0, 6.5, 8.0, 4.0, 12.0,
                3.0, 10.0, 5.0, 1.0, 3.5, true,
                false, false, true, true, true);
        Fish swordtail = new Fish("Swordtail", "Xiphophorus hellerii", "Omnivore",
                "swordtail", new String[]{}, new String[]{"Algae flakes", "Algae granules"},
                new String[]{"Gravel", "Sand"}, 1, 2, 0, 2,
                3, 0, 22.0, 27.0, 7.0, 8.0,
                4.0, 12.0, 3.0, 10.0, 10.0,
                0.0, 4.0, false, false, false, true,
                true, true);
        Fish gourami = new Fish("Gourami", "Osphronemidae", "Omnivore",
                "gourami", new String[]{}, new String[]{"Flakes", "Granules", "Pellets"},
                new String[]{"Gravel", "Sand"}, 0, 0, 1, 2,
                3, 0, 20.0, 28.0, 6.0, 8.0,
                4.0, 12.0, 3.0, 10.0, 13.5,
                4.0, 3.5, true, true, true, false,
                true, false);
        Fish dwarfCichlid = new Fish("Dwarf Cichlid", "Apistogramma cichlid", "Omnivore",
                "dwarf_cichlid", new String[]{}, new String[]{"Flakes", "Granules"},
                new String[]{"Gravel", "Sand"}, 1, 2, 0, 0,
                2, 0, 22.0, 27.0, 6.0, 8.0,
                4.0, 12.0, 3.0, 10.0, 7.5,
                2.0, 7.5, true, true, true, true,
                true, true);
        Fish angelfish = new Fish("Angelfish", "Pterophyllum scalare", "Omnivore",
                "angelfish", new String[]{"Freshwater angelfish"},
                new String[]{"Protein flakes", "Protein pellets"}, new String[]{"Sand", "Mud"},
                1, 2, 1, 1, 2, 0, 25.0,
                28.0, 6.8, 7.0, 4.0, 12.0,
                3.0, 10.0, 9.0, 2.5, 11.0, true,
                true, true, true, true, false);
        Fish platy = new Fish("Platy", "Xiphophorus maculatus", "Omnivore",
                "platy", new String[]{"Southern platyfish", "Common platy", "Moonfish"},
                new String[]{"Algae flakes", "Algae granules"}, new String[]{"Gravel", "Sand"},
                1, 2, 1, 1, 3, 0, 17.0,
                27.0, 7.0, 8.0, 4.0, 12.0,
                3.0, 10.0, 7.0, 1.0, 3.5, true,
                false, false, true, false, true);

        fishes = new Fish[]{goldfish, fancyGoldfish, endlerGuppy, hillstreamLoach, weatherLoach,
                betta, glassCatfish, pleco, bronzeCory, molly, danio, swordtail, gourami,
                dwarfCichlid, angelfish, platy};
    }

    @Test
    public void noResults() {
        ArrayList<Fish> expectedArray = new ArrayList<>();
        Search search = new Search();

        assertEquals(expectedArray, search.searchFish("test", fishes));
    }

    @Test
    public void oneResult() {
        ArrayList<Fish> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(fishes[5]);

        assertEquals("Exact text entered", expectedArray,
                search.searchFish("Betta", fishes));
        assertEquals("Exact text entered - without capitals", expectedArray,
                search.searchFish("betta", fishes));
        assertEquals("Exact text not entered", expectedArray,
                search.searchFish("Bett", fishes));
        assertEquals("Exact text not entered - without capitals", expectedArray,
                search.searchFish("bett", fishes));
    }

    @Test
    public void twoResults() {
        ArrayList<Fish> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(fishes[0]);
        expectedArray.add(fishes[1]);

        assertEquals("Name contains query", expectedArray,
                search.searchFish("goldfish", fishes));

        expectedArray.clear();
        expectedArray.add(fishes[1]);
        expectedArray.add(fishes[11]);

        assertEquals("Alias contains query", expectedArray,
                search.searchFish("tail", fishes));
    }

    @Test
    public void manyResults() {
        ArrayList<Fish> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(fishes[0]);
        expectedArray.add(fishes[1]);
        expectedArray.add(fishes[4]);
        expectedArray.add(fishes[5]);
        expectedArray.add(fishes[6]);
        expectedArray.add(fishes[7]);
        expectedArray.add(fishes[14]);
        expectedArray.add(fishes[15]);

        assertEquals(expectedArray, search.searchFish("fish", fishes));
    }

    @AfterClass
    public static void clear() {
        fishes = null;
    }
}
