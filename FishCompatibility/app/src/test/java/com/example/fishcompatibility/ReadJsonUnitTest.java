package com.example.fishcompatibility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadJsonUnitTest {
    private static Fish[] fishes;
    private static Disease[] diseases;

    /**
     * Run before all tests to populate fish array
     */
    @BeforeClass
    public static void setupFish() {
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
                        "Fish with damaged gills may need more oxygen than normal"});
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
    public void testReadFish() {
// TODO: Needs to be an integration test
    }

    @AfterClass
    public static void clear() {
        fishes = null;
    }
}
