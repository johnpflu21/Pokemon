/*
John Pflugrad
9/21/23
Final Project - Pokedex
Assignment 03
 */

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class PokedexDriver {
    public static void runPokedexDriver() {

        SoundBoard endingSound = new SoundBoard();

        boolean continueRunning = true;
        while (continueRunning) {
            BufferedReader br = null;
            try {
                // Reading the csv file
                br = new BufferedReader(new FileReader("src/pokemon.csv"));

                // Create Map for holding Pokémon objects
                Map<String, Pokemon> pokemonMap = new HashMap<>();

                String line = "";
                // Read to skip the header
                br.readLine();
                // Reading from the second line
                while ((line = br.readLine()) != null) {
                    String[] pokemonDetails = line.split(",");
                    // When the string is split, it will result in an array with the following information in the corresponding index
                    // 0 - #
                    // 1 - Name
                    // 2 - Type1
                    // 3 - Type2
                    // 4 - Total
                    // 5 - HP
                    // 6 - Attack
                    // 7 - Defense
                    // 8 - Sp. Atk
                    // 9 - Sp. Def
                    // 10 - Speed
                    // 11 - Generation
                    // 12 - Legendary

                    if (pokemonDetails.length == 13) {
                        // Create a temporary Pokémon
                        Pokemon pokemon = new Pokemon();

                        // Save the Pokémon details in Pokemon object
                        pokemon.setIndex(Integer.parseInt(pokemonDetails[0]));
                        pokemon.setName(pokemonDetails[1]);
                        pokemon.setTypeone(pokemonDetails[2]);
                        pokemon.setTypetwo(pokemonDetails[3]);
                        pokemon.setTotal(Integer.parseInt(pokemonDetails[4]));
                        pokemon.setHp(Integer.parseInt(pokemonDetails[5]));
                        pokemon.setAttack(Integer.parseInt(pokemonDetails[6]));
                        pokemon.setDefense(Integer.parseInt(pokemonDetails[7]));
                        pokemon.setSpecialatk(Integer.parseInt(pokemonDetails[8]));
                        pokemon.setSpecialdef(Integer.parseInt(pokemonDetails[9]));
                        pokemon.setSpeed(Integer.parseInt(pokemonDetails[10]));
                        pokemon.setGeneration(Integer.parseInt(pokemonDetails[11]));
                        pokemon.setLegend(Boolean.parseBoolean(pokemonDetails[12]));

                        // Add the temporary Pokémon to the Map object
                        pokemonMap.put(pokemon.getName(), pokemon);
                    }
                } // end of the while loop

                System.out.println(pokemonMap);

                // Printing out all Pokémon stats
                for (Pokemon pokemon : pokemonMap.values()) {
                    System.out.println(pokemon.getIndex() + " ");
                    System.out.print("Name: " + pokemon.getName() + " ");
                    System.out.print("Type One: " + pokemon.getTypeone() + " ");
                    System.out.print("Type Two: " + pokemon.getTypetwo() + " ");
                    System.out.print("Total: " + pokemon.getTotal() + " ");
                    System.out.print("HP: " + pokemon.getHp() + " ");
                    System.out.print("Attack: " + pokemon.getAttack() + " ");
                    System.out.print("Defense: " + pokemon.getDefense() + " ");
                    System.out.print("Sp. Atk: " + pokemon.getSpecialatk() + " ");
                    System.out.print("Sp. Def: " + pokemon.getSpecialdef() + " ");
                    System.out.print("Speed: " + pokemon.getSpeed() + " ");
                    System.out.print("Generation: " + pokemon.getGeneration() + " ");
                    System.out.println("Legendary: " + pokemon.getLegend());
                }

                Scanner choice = new Scanner(System.in);
                System.out.println("\nWhat would you like to do? 1 or 2");
                System.out.println("(1) Search for a Pokemon");
                System.out.println("(2) Add a Pokemon to the Pokedex");
                System.out.println("(3) Exit");
                int userChoice = choice.nextInt();
                if (userChoice == 1) {
                    searchForPokemon(pokemonMap);
                } else if (userChoice == 2) {
                    addNewPokemon(pokemonMap);
                } else if (userChoice == 3) {
                    System.out.println("Exiting........");
                    endingSound.ending();
                    System.exit(0);
                } else {
                    System.out.println("Invalid Choice...");
                }

                // Ask the user if they want to continue
                System.out.println("Do you want to continue? (yes/no)");
                Scanner continueScanner = new Scanner(System.in);
                String continueChoice = continueScanner.next().toLowerCase();
                if (!continueChoice.equals("yes")) {
                    continueRunning = false;
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException ie) {
                    System.out.println("Error occurred while closing the BufferedReader");
                    ie.printStackTrace();
                }
            }
        }
    }

    private static void searchForPokemon(Map<String, Pokemon> pokemonMap) { // Function for searching for a Pokemon

        SoundBoard searchSound = new SoundBoard(); // For playing a sound

        Scanner searchScanner = new Scanner(System.in);//
        System.out.println("What Pokemon do you want to find?"); // Prompt for typing what Pokemon you want to find
        String searchName = searchScanner.next();// Scans for user input

        if (pokemonMap.containsKey(searchName)) { // If it's found It will print the Pokemon and it's details
            searchSound.searching();
            Pokemon foundPokemon = pokemonMap.get(searchName);
            System.out.println("\nPokemon found:");
            System.out.println("Name: " + foundPokemon.getName() + "\nType One: " + foundPokemon.getTypeone() + "\nType Two: " +
                    foundPokemon.getTypetwo() + "\nTotal: " + foundPokemon.getTotal() + "\nHP: " + foundPokemon.getHp() + "\nAttack: " +
                    foundPokemon.getAttack() + "\nDefense: " + foundPokemon.getDefense() + "\nSp Atk: " + foundPokemon.getSpecialatk() +
                    "\nSp Def: " + foundPokemon.getSpecialdef() + "\nSpeed: " + foundPokemon.getSpeed() + "\nGeneration: " +
                    foundPokemon.getGeneration() + "\nLegendary: " + foundPokemon.getLegend());
        } else {
            System.out.println("Pokemon not found..."); // If not this will print with a sound
            searchSound.ending();
        }
    }

    private static void addNewPokemon(Map<String, Pokemon> pokemonMap) { // function for adding a Pokemon
        Scanner twoScanner = new Scanner(System.in); // Scanner for input
        Pokemon newPokemon = new Pokemon(); // New Pokemon

        SoundBoard addSound = new SoundBoard(); // for playing sounds

        int maxIndex = pokemonMap.values().stream()// This determines Index that is the highest number or the max
                .mapToInt(Pokemon::getIndex)
                .max()
                .orElse(0);

        newPokemon.setIndex(maxIndex + 1); // This sets the index when adding a Pokemon to one mre than the previous

        // Interface for adding a Pokemon; The prompt and the scanner for each attribute
        System.out.println("\nAdd a New Pokemon:");
        System.out.println("Enter Pokemon details");
        System.out.println("Name: ");
        newPokemon.setName(twoScanner.next());
        System.out.println("Type One: ");
        newPokemon.setTypeone(twoScanner.next());
        System.out.println("Type Two: ");
        newPokemon.setTypetwo(twoScanner.next());
        System.out.println("Total: ");
        newPokemon.setTotal(twoScanner.nextInt());
        System.out.println("HP: ");
        newPokemon.setHp(twoScanner.nextInt());
        System.out.println("Attack: ");
        newPokemon.setAttack(twoScanner.nextInt());
        System.out.println("Defense: ");
        newPokemon.setDefense(twoScanner.nextInt());
        System.out.println("Sp Atk: ");
        newPokemon.setSpecialatk(twoScanner.nextInt());
        System.out.println("Sp Def: ");
        newPokemon.setSpecialdef(twoScanner.nextInt());
        System.out.println("Speed: ");
        newPokemon.setSpeed(twoScanner.nextInt());
        System.out.println("Generation: ");
        newPokemon.setGeneration(twoScanner.nextInt());
        System.out.println("Legendary(True or False): ");
        newPokemon.setLegend(twoScanner.nextBoolean());

        pokemonMap.put(newPokemon.getName(), newPokemon);

        // Writer to write to the csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/pokemon.csv", true))) {
            writer.write("\n" + newPokemon.getIndex() + "," +
                    newPokemon.getName() + "," +
                    newPokemon.getTypeone() + "," +
                    newPokemon.getTypetwo() + "," +
                    newPokemon.getTotal() + "," +
                    newPokemon.getHp() + "," +
                    newPokemon.getAttack() + "," +
                    newPokemon.getDefense() + "," +
                    newPokemon.getSpecialatk() + "," +
                    newPokemon.getSpecialdef() + "," +
                    newPokemon.getSpeed() + "," +
                    newPokemon.getGeneration() + "," +
                    newPokemon.getLegend());
            System.out.println("Pokemon has been added");// Prints when pokemon is added and plays sound
            addSound.play();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in writing to the file"); // Error prints this
        }
    }
}