
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Optional;

public class App {

    FileService fileSvc;
    public static String pokemon;

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        if (args.length > 0) {
            fileName = "data/Rush2.csv";
        }
        // Run Your Code here
        boolean quit = false;

        while (!quit) {
            printHeader(); // step 1
            // pressAnyKeyToContinue(); // step 2

            Console console = System.console();
            String line = console.readLine("Enter your selection >");
            // System.out.println("\n");

            // if quit / other cases
            switch (line) {
                case Constants.ONE:
                    // FileService.ReadCSV(fileName);
                    // FileService.pokeMap(fileName);

                    Integer input = Integer.parseInt(line);
                    printUniquePokemonStack(fileName, input);

                    break;

                case Constants.TWO:

                    printNext5StarsPokemon(fileName, pokemon);
                    break;

                case Constants.THREE:

                    String pokemon = "";
                    // System.out.println("Create a new Pokemon stack and save to a file");
                    FileService.writeAsCSV(pokemon, fileName);
                    break;

                case Constants.FOUR:

                    printPokemonCardCount(fileName);

                    break;

                case Constants.QUIT:

                    // if (quit = line.trim().trim().toLowerCase().equals(Constants.QUIT)) {
                    // System.lineSeparator();
                    printExitMessage();
                    // }

                    break;

                default:
                    break;
            }

        }

    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        // your code here
        Console console = System.console();
        String line;
        // line = console.readLine("Enter your selection >");
    }

    // Task 1
    public static void printHeader() {

        // Task 1 - your code here
        System.out.println("\nWelcome to Pokemon Gaole Legend 4 Rush 2\n");
        System.out.printf("(%s) View unique list of Pokemon in the selected stack\n", Constants.ONE);
        System.out.printf("(%s) Find next 5 stars Pokemon occurrence\n", Constants.TWO);
        System.out.printf("(%s) Create a new Pokemon stack and save (append) to csv file\n", Constants.THREE);
        System.out.printf("(%s) Print distinct Pokemon and cards count\n", Constants.FOUR);
        System.out.printf("(%s) To exit the program\n", Constants.QUIT, System.lineSeparator());
    }

    // Task 1
    public static void printExitMessage() {

        // Task 1 - your code here
        System.out.println();
        System.out.printf("Thank you for using the program...\n");
        System.out.printf("Hope to see you soon...");
        System.exit(0);
    }

    // Task 1
    public static void savePokemonStack(String pokemonStack, String filename) {

        // Task 1 - your code here

    }

    // Task 2
    public static void printUniquePokemonStack(String fileName, Integer stack) {
        // Task 2 - your code here
        Console console = System.console();
        String line = console.readLine("Display the list of unique Pokemon in stack (1 - 8) > ");

        if (Integer.valueOf(line) > 8 || Integer.valueOf(line) < 0) {
            System.err.println("Please enter a number between 1 to 8!");
        }

        // FileService.pokeMap(fileName);
        for (Entry<Integer, List<String>> entry : FileService.pokeMap(fileName).entrySet()) {
            Integer key = entry.getKey();

            if (Integer.valueOf(line) == key) {

                String[] values = {};

                for (String val : entry.getValue()) {
                    values = val.split(",");
                    int count = 1;
                    for (int i = 0; i < values.length; i++) {
                        // i+=1;
                        System.out.printf(count + " ==> " + values[i] + "\n");
                        count++;
                    }
                }

            }
        }

    }

    // Task 2
    public static void printNext5StarsPokemon(String fileName, String enteredPokemon) {
        // Task 2 - your code here

        Console console = System.console();
        String line = console.readLine(
                "Search for the next occurrence of 5 stars Pokemon in all stacks based on the entered Pokemon > "
                        + "\n");

        for (Entry<Integer, List<String>> entry : FileService.pokeMap(fileName).entrySet()) {

            int key = entry.getKey();
            System.out.println(key);

            for (String value : entry.getValue()) {
                while (!value.equals(enteredPokemon)) {
                    System.out.printf("Set %d", key + "\n");
                    if (!entry.getValue().contains(enteredPokemon)) {

                        System.out.printf("%s not found in this set", enteredPokemon + "\n");

                    } else {

                        // if ()

                    }

                }
            }

        }

    }

    // Task 2
    public static void printPokemonCardCount(String fileName) {
        // Task 2 - your code here
        // try(FileReader fr = new FileReader(fileName)) {
        //     BufferedReader br = new BufferedReader(fr);

        // int count = 0;

            List<String> lines = FileService.ReadCSV(fileName);

            Map<String, Integer> pokemonMap = new HashMap<>();
            
            for (String line : lines) {
                pokemonMap.put(line, pokemonMap.getOrDefault(pokemonMap, 0)+1);
                System.out.printf("Pokemon 1 : %s, Cards Count: %d", line);
            }
            
            
            System.out.println(pokemonMap.entrySet());
            // Optional<Integer> opt = br.lines().
                
        



    }

}
