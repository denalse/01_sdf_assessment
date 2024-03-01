
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Run Your Code here
        boolean quit = false;

        while (!quit) {
            printHeader(); // step 1
            pressAnyKeyToContinue(); // step 2

            Console console = System.console();
            String line = console.readLine("Enter your selection >");
            if (quit = line.trim().trim().toLowerCase().equals(Constants.QUIT)) {
                System.lineSeparator();
                printExitMessage();
            }

        }

        // String fileName = args[0];
        // if (args.length > 0) {
        // fileName = "data/Rush2.csv";
        // }

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
        System.out.printf("(%d) View unique list of Pokemon in the selected stack\n", Constants.ONE);
        System.out.printf("(%d) Find next 5 stars Pokemon occurrence\n", Constants.TWO);
        System.out.printf("(%d) Create a new Pokemon stack and save (append) to csv file\n", Constants.THREE);
        System.out.printf("(%d) Print distinct Pokemon and cards count\n", Constants.FOUR);
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
    public static void printUniquePokemonStack(Integer stack) {
        // Task 2 - your code here
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
