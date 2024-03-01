
import java.io.IOException;


public class App {

    public static void main(String[] args) throws Exception {

        String fileName = args[0];
        // Run Your Code here
        if (args.length > 0) {
            fileName = "data/Rush2.csv";
        }

        


    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        // your code here
    }

    // Task 1
    public static void printHeader() {

        // Task 1 - your code here
    }

    // Task 1
    public static void printExitMessage() {

        // Task 1 - your code here
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
