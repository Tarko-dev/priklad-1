import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVLoader {

    private List<String[]> csvData;

    /**
     * Loads data from a CSV file and returns a {@link CSVData} object containing the parsed data.
     *
     * @param filename The path to the CSV file to be loaded.
     * @return A {@link CSVData} object representing the parsed CSV data.
     * @throws IOException If there is an error reading the CSV file.
     * @throws CsvException If there is an issue parsing the CSV data.
     */

    public CSVData loadCSV(String filename){
        Map<String, Integer> data = new HashMap<>();
        List<String> columnsNames = new ArrayList<>();
        boolean columnsLoaded = false;

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            csvData = reader.readAll();

            csvData.stream().skip(1).
                    filter(row -> row.length==2 )
                    .forEach(row -> {
                    Integer value = Integer.valueOf(row[1]);
                    data.put(row[0], value);
            });

            columnsNames = Arrays.stream(csvData.stream()
                    .filter(row -> row.length==2)
                    .findFirst().get()).toList();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return new CSVData(columnsNames, data);
    }



}
