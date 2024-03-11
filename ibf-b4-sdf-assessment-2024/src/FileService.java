import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

                    for (String data : datas) {
                        records.add(data);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return records;
    }

    public static Map<Integer, List<String>> pokeMap(String fullPathFilename) {

        try (BufferedReader br = new BufferedReader(new FileReader(fullPathFilename))) {
            String line;
            List<List<String>> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(Arrays.asList(line));

            }

            for (int i = 0; i < list.size(); i++) {
                stacks.put(i+1, list.get(i));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stacks;
    }

    public static void writeAsCSV(String pokemons, String fullPathFilename) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPathFilename))) {

                File file = new File(fullPathFilename);
                if (!file.exists() && !file.isDirectory()) {
                    file.createNewFile();
                }
                bw.write(pokemons);
                bw.flush();

            System.out.println("Pokemons successfully saved to " + fullPathFilename + "\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
