
import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

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

                    break;

                case Constants.THREE:

                    String pokemon = "";
                    // System.out.println("Create a new Pokemon stack and save to a file");
                    FileService.writeAsCSV(pokemon, fileName);
                    break;

                case Constants.FOUR:

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
                // for (int i = 0; i < key.; i++) {
                List<String> values = entry.getValue();
                System.out.printf("1. ==> " + entry.getValue());
            }
        }

    }

    // Task 2
    public static void printNext5StarsPokemon(String enteredPokemon) {
        // Task 2 - your code here

    }

    // Task 2
    public static void printPokemonCardCount() {
        // Task 2 - your code here
    }

}
