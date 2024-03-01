import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<String> ReadCSV(String fullPathFilename)  {
        // Task 1 - your code here
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fullPathFilename))) {
            String line;

            while ((line = br.readLine()) != null) { 
                String values
            }

        } catch (Exception ex ) {
            ex.printStackTrace();
        }

        return records;
    }

    public void writeAsCSV(String pokemons, String fullPathFilename) {
        // Task 1 - your code here

    }
}
