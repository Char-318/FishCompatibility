package com.example.fishcompatibility;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class SearchDiseaseUnitTest {
    private static Disease[] diseases;

    @BeforeClass
    public static void setupDiseases() {
        Disease ammoniaPoisoning = new Disease("Ammonia Poisoning", new String[]{},
                new String[]{"Rapid breathing", "Gasping", "Mucus hyperproduction", "Reddened skin",
                        "Darting and twitching"},
                new String[]{"Overcrowding", "Overfeeding", "Poor filtration", "Waste matter"},
                new String[]{"Maintain good water quality", "Check the filter regularly",
                        "Adding zeolite to fish bags and hospital tanks"},
                new String[]{"Can be adjusted with zeolite or a new matured filter"});
        Disease carbonPoisoning = new Disease("Carbon Dioxide Poisoning", new String[]{},
                new String[]{"Rapid breathing", "Loss of appetite", "Reduced growth rate",
                        "Hypoxia"},
                new String[]{"High content of carbon dioxide", "Transporting fish"},
                new String[]{"Good water circulation", "Aerate heavily planted aquariums",
                        "Avoid overcrowding"},
                new String[]{"Increase aeration and improve water circulation",
                        "Move an asphyxiated fish back and forth in the water until it starts " +
                                "breathing"});
        Disease gasBubble = new Disease("Gas Bubble Poisoning", new String[]{},
                new String[]{"Blindness", "Bubbles on the fish, particularly around the gills",
                        "Lethargy"},
                new String[]{"Partial water changes with cold water"},
                new String[]{"Heat new water before adding it to the aquarium"},
                new String[]{"Move the fish to a separate aquarium", "Aerate or agitate the water"}
        );
        Disease hypoxia = new Disease("Hypoxia", new String[]{},
                new String[]{"Staring and unresponsive eyes", "Abnormal colouration",
                        "Swimming near the surface and gasping", "Loss of bouyancy",
                        "Rests at the bottom of the tank", "Rapid breathing"},
                new String[]{"Insufficient oxygen content in the water", "Increased temperature",
                        "Not enough aeration", "Increased bacteria in the tank", "Gill damage",
                        "Nitrite damaging the red blood cells", "High levels of carbon dioxide"},
                new String[]{"Maintain the correct level of aeration"},
                new String[]{"Aerate the aquarium vigourously", "Partial water change",
                        "Adding hydrogen peroxide in emergencies",
                        "Disease with damaged gills may need more oxygen than normal"});
        Disease anchorWorm = new Disease("Anchor Worm", new String[]{},
                new String[]{"Y-shaped, elongated parasite on the body", "Holes in the body",
                        "Scratching", "Hypoxia"},
                new String[]{"Parasites reproduce on the infected fish and the new ones release " +
                        "and swim onto other fish"},
                new String[]{"Don't buy fish from tank with fish that have visible parasites",
                        "Avoid putting water from live food into the tank"},
                new String[]{"Isolate the infected fish",
                        "If the fish is large enough, remove parasites in small batches with " +
                                "forceps and treat the wound with antiseptic",
                        "Larvae can be removed with medication"});
        Disease skinFlukes = new Disease("Skin Flukes", new String[]{},
                new String[]{"Coughing", "Scratching", "Mucus hyperproduction",
                        "Red patches on the skin", "Ulcers", "Frayed fins", "Clamped fins"},
                new String[]{"Spread through direct contact", "Overcrowding",
                        "Poor aquarium hygiene"},
                new String[]{"Maintain good aquarium hygiene", "Avoid overcrowding",
                        "Quarantine new fish"},
                new String[]{"Bath immersion in medication", "Bath immersion in salt"});
        Disease ich = new Disease("Ich", new String[]{},
                new String[]{"Small white spots", "Coughing", "Short darting movements",
                        "Scratching", "Frayed fins", "Twitching fins", "Increased breathing",
                        "Gasping", "Resting at the bottom of the tank"},
                new String[]{"Smaller fish are more susceptible", "Chilling", "Infected fish",
                        "Infected water from new fish, live food or plants"},
                new String[]{"Quarantine new fish"},
                new String[]{"Medication", "Salt", "Remove parasites from plants and decor"});
        Disease velvetDisease = new Disease("Velvet Disease", new String[]{},
                new String[]{"Coughing", "Small yellow or green spots", "Scratching",
                        "Clamped fins", "Shimmying", "Fin twitching", "Mucus hyperproduction",
                        "Increased breathing rate", "Lethargy", "Loss of appetite"},
                new String[]{"Parasite feeds beneath the skin, then falls off to reproduce in the" +
                        " substrate"},
                new String[]{"Quarantine new fish"},
                new String[]{"Medication in the water", "Increase temperature unless infestation " +
                        "is severe", "Turn off aquarium and room lights"});
        Disease lymphocystis = new Disease("Lymphocystis", new String[]{"Cauliflower disease"},
                new String[]{"Small white spots that grow larger", "Loss of appetite"},
                new String[]{"Not very infectious", "Spread through damaged skin or ingesting the" +
                        " cysts", "Spread through direct contact"},
                new String[]{"Quarantine new fish"},
                new String[]{"Quarantine the infected fish", "Normally disappears on its own",
                        "Surgery to remove cysts"});
        Disease finRot = new Disease("Fin Rot", new String[]{},
                new String[]{"Red spots or streaks on the fins", "Tears in the fins"},
                new String[]{"Spread through the water or from fish", "Injury",
                        "Poor water quality", "Stress"},
                new String[]{"Maintain good water quality", "Avoid fin nippers"},
                new String[]{"Medication", "Salt"});
        Disease fishTB = new Disease("Fish Tuberculosis", new String[]{},
                new String[]{"Pale raised lumps", "Loss of appetite", "Weight loss",
                        "Pale colouration", "Change in shape", "Lethargy", "Skin ulcers"},
                new String[]{"Ingesting microbacteria from ulcers, faeces or carcasses",
                        "Spread through eggs or embryos", "Poor tank conditions"},
                new String[]{"Isolate potentially infected fish", "Maintain good aquarium hygiene"},
                new String[]{"Antibiotics", "Euthanasia"});
        Disease cottonWool = new Disease("Cotton Wool Disease", new String[]{},
                new String[]{"White tufts around a wound", "Growths may become red or brown"},
                new String[]{"Fungi attacking damaged tissues", "Poor aquarium hygiene", "Stress",
                        "Chilling", "Old age", "Injuries", "Disease"},
                new String[]{"Minimise stress", "Maintain good water conditions"},
                new String[]{"Salt bath immersion in a separate tank", "Fungicide",
                        "Gentian violet if the fish is healthy"});
        Disease gillRot = new Disease("Gill Rot", new String[]{},
                new String[]{"Coughing", "Yawning", "Hypoxia", "Dark red gills",
                        "Erosion of gill filaments", "Mucus hyperproduction"},
                new String[]{"Spores in the water or from new fish", "Poor water quality",
                        "Overcrowding", "High levels of algae", "Temperatures over 20 °C"},
                new String[]{"Maintain good water quality"},
                new String[]{"Bath immersion in fungicide", "Increase aeration"});
        Disease dropsy = new Disease("Dropsy", new String[]{},
                new String[]{"Bloated body", "Protruding scales", "Pale red colouration of the " +
                        "abdomen", "Lethargy", "Gasping", "Rapid breathing", "Ulcers"},
                new String[]{"Bacterial or viral infection", "Osmoregulatory problems",
                        "Poor water quality", "Immune problems", "Insufficient nutrition"},
                new String[]{"Minimise stress", "Maintain good water conditions",
                        "Maintain good diet"},
                new String[]{"Medication"});
        Disease popEye = new Disease("Pop Eye", new String[]{},
                new String[]{"Cloudy eyes", "Bulging eyes"},
                new String[]{"Eye flukes", "Bacterial, viral or fungal infection",
                        "Vitamin deficiency", "Osmoregulation problems", "Poor water quality"},
                new String[]{"Maintain good water quality"},
                new String[]{"Needs urgent attention from a vet", "Partial water change"});

        diseases = new Disease[]{ammoniaPoisoning, carbonPoisoning, gasBubble, hypoxia, anchorWorm,
                skinFlukes, ich, velvetDisease, lymphocystis, finRot, fishTB, cottonWool, gillRot,
                dropsy, popEye};
    }

    @Test
    public void noResults() {
        ArrayList<Disease> expectedArray = new ArrayList<>();
        Search search = new Search();

        assertEquals(expectedArray, search.searchDisease("test", diseases));
    }

    @Test
    public void oneResult() {
        ArrayList<Disease> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(diseases[3]);

        assertEquals("Exact text entered", expectedArray,
                search.searchDisease("Hypoxia", diseases));
        assertEquals("Exact text entered - without capitals", expectedArray,
                search.searchDisease("hypoxia", diseases));
        assertEquals("Exact text not entered", expectedArray,
                search.searchDisease("Hypox", diseases));
        assertEquals("Exact text not entered - without capitals", expectedArray,
                search.searchDisease("hypox", diseases));
    }

    @Test
    public void multipleResults() {
        ArrayList<Disease> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(diseases[9]);
        expectedArray.add(diseases[12]);

        assertEquals("Name contains query", expectedArray,
                search.searchDisease("rot", diseases));

        expectedArray.clear();
        expectedArray.add(diseases[7]);
        expectedArray.add(diseases[8]);
        expectedArray.add(diseases[11]);

        assertEquals("Alias contains query", expectedArray,
                search.searchDisease("disease", diseases));
    }

    @Test
    public void manyResults() {
        ArrayList<Disease> expectedArray = new ArrayList<>();
        Search search = new Search();
        expectedArray.add(diseases[0]);
        expectedArray.add(diseases[1]);
        expectedArray.add(diseases[2]);
        expectedArray.add(diseases[3]);
        expectedArray.add(diseases[4]);
        expectedArray.add(diseases[7]);
        expectedArray.add(diseases[8]);
        expectedArray.add(diseases[11]);

        assertEquals(expectedArray, search.searchDisease("a", diseases));
    }


    @AfterClass
    public static void clear() { diseases = null; }
}
