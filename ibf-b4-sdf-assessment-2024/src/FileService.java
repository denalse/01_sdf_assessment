import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.File;
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
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // System.out.println(records);
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

            for (int i = 0; i < list.size(); i++) {
                stacks.put(i+1, list.get(i));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // System.out.println(stacks.entrySet());
        return stacks;
    }

    public static void writeAsCSV(String pokemons, String fullPathFilename) {
        // Task 1 - your code here
        // try (BufferedReader br = new BufferedReader(new
        // FileReader(fullPathFilename))) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPathFilename))) {
        //     // String line;
        //     Scanner scan = new Scanner(System.in);
        //     System.out.println("Create a new Pokemon stack and save to a new file > ");

        //     String data = scan.nextLine();
        //     String fileName = scan.nextLine();

        //     while (scan.next() != null) {
        //         // List<String> newStack = out.write(line);
        //         bw.write(data);
        //         bw.newLine();
        //         bw.flush();
                
        //         System.out.println("Enter filename to save (e.g. path/filename.csv) > ");
                File file = new File(fullPathFilename);
                if (!file.exists() && !file.isDirectory()) {
                    file.createNewFile();
                }
                bw.write(pokemons);
                bw.flush();

            // }
            // scan.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
