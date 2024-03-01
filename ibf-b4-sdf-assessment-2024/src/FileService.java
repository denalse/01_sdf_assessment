import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileService {

    public static List<String> records = new ArrayList<>();
    public static Map<Integer, List<String>> stacks = new HashMap<>();

    /**
     * @param fullPathFilename
     * @return
     */

    // store into a list of pokemon datas
    public static List<String> ReadCSV(String fullPathFilename) {
        // Task 1 - your code here

        try (BufferedReader br = new BufferedReader(new FileReader(fullPathFilename))) {

            try (Scanner scan = new Scanner(br)) {

                String line;

                while ((scan.hasNextLine())) {
                    line = scan.nextLine();
                    String[] datas = line.split("\n");

                    // System.out.println(Arrays.toString(datas));
                    for (String data : datas) {
                        records.add(data);
                        // System.out.println("line::>>>>>>" + data + "\n");
                        // Integer i = 0;
                        // stacks.put(++i, records);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(records);
        return records;
    }

    public static Map<Integer, List<String>> pokeMap(String fullPathFilename) {

        try (BufferedReader br = new BufferedReader(new FileReader(fullPathFilename))) {
            String line;
            List<List<String>> list = new ArrayList<>();
            // Scanner scan = new Scanner(br);
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                list.add(Arrays.asList(line));

            }
            // System.out.println(list);
            List<String> res = new ArrayList<String>();
            for (List<String> lst : list) {
                // Integer i = 0;
                // System.out.println(">>>>" + lst);

                for (int i = 0; i < 9; i++) {
                    stacks.put(i, lst);

                }
            }
            System.out.println(stacks);

        } catch (FileNotFoundException | EOFException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stacks;
    }

    public static void writeAsCSV(String pokemons, String fullPathFilename) {
        // Task 1 - your code here
        // try (BufferedReader br = new BufferedReader(new
        // FileReader(fullPathFilename))) {

        String line;
        Console console = System.console();
        line = console.readLine("Create a new Pokemon stack and save to a new file > " + "\n");
        
        try (PrintStream out = new PrintStream(new FileOutputStream(fullPathFilename))) {
            System.setOut(out);

            while (line != null) {
                // List<String> newStack = out.write(line);
                System.out.println("POP>>>>>>>" + out);
                out.flush();
                out.flush();

                fullPathFilename = console.readLine("Enter filename to save (e.g. path/filename.csv) > " + "\n");
                
                // if (fullPathFilename == )
                
                // out.

            }
            out.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
