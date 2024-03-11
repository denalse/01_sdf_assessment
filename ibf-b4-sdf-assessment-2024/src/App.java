
import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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

            Console console = System.console();
            String line = console.readLine("Enter your selection >");

            // if quit / other cases
            switch (line) {
                case Constants.ONE:
                    Integer input = Integer.parseInt(line);
                    printUniquePokemonStack(fileName, input);
                    pressAnyKeyToContinue();
                    break;

                case Constants.TWO:

                    printNext5StarsPokemon(fileName, pokemon);
                    pressAnyKeyToContinue();
                    break;

                case Constants.THREE:

                    String pokemon = console.readLine("Create a new Pokemon stack and save to a new file > ");
                    // System.out.println("Create a new Pokemon stack and save to a file");
                    String _fileName = console.readLine("Enter filename to save (e.g. path/filename.csv) > ");
                    FileService.writeAsCSV(pokemon, _fileName);
                    pressAnyKeyToContinue();
                    break;

                case Constants.FOUR:

                    printPokemonCardCount(fileName);
                    pressAnyKeyToContinue();

                    break;

                case Constants.QUIT:
                    printExitMessage();
                    // }

                    break;

                default:
                    System.out.println("\nYou have entered an invalid character, please try again.");
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
        console.readLine("Press any key to continue...");
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
        // 4* Espeon

        // Task 2 - your code here
        Console console = System.console();
        enteredPokemon = console
                .readLine("Search for the next occurence of 5 stars pokemon in all stacks based on entered pokemon > ");

        Map<Integer, List<String>> map = FileService.pokeMap(fileName);

        int count = 0;

        for (int i = 1; i <= 8; i++) {

            String[] pokeArr = map.get(i).get(0).split(",");
            Boolean pokemonExist = false;
            Boolean fiveStar = false;
            int cardsCount = 0;
            String fiveStarPokemon = "";
            System.out.printf("Set %d\n", i);
            
            for (int j = 0; j < pokeArr.length; j++) {
                if(pokeArr[j].equals(enteredPokemon)) {
                    pokemonExist = true;
                }
                if (pokeArr[j].contains("5*")) {
                    fiveStar = true;
                    fiveStarPokemon = pokeArr[j];
                    cardsCount = count;
                }
                count+=1;
            }

            if (!pokemonExist) {
                System.out.printf("%s not found in this set.\n", enteredPokemon);
            }
            if (pokemonExist && !fiveStar) {
                System.out.printf("No 5 stars Pokemon found subsequently in the stack.\n");
            }
            if (pokemonExist && fiveStar) {
                System.out.printf("%s found >>> %d cards to go.\n", fiveStarPokemon, cardsCount);
            }

        }

    }

    // Task 2
    public static void printPokemonCardCount(String fileName) {
        // Task 2 - your code here

        List<String> lines = FileService.ReadCSV(fileName);

        Map<String, Integer> pokemonMap = new HashMap<>();

        for (String line : lines) {
            String[] data = line.split(",");
            
            for (String d : data) {
                pokemonMap.put(d, pokemonMap.getOrDefault(d, 0) + 1);
            }
        }
        AtomicInteger counter = new AtomicInteger(0);
        Optional<String> opt = pokemonMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(10)
                .map(entry -> {
                    int index = counter.incrementAndGet();
                    return "Pokemon " + index + ": " + entry.getKey() + ", Cards Count: "
                            + entry.getValue();
                })
                .reduce((result, entry) -> result + "\n" + entry);
        opt.ifPresent(System.out::println);

    }

}
