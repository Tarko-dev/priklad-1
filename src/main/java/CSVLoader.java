import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            for (String[] row : csvData)
                if (row.length==2){
                    try {
                        Integer value = Integer.valueOf(row[1]);
                        data.put(row[0], value);
                    } catch (NumberFormatException e) {
                        if (!columnsLoaded){
                            columnsNames.add(row[0]);
                            columnsNames.add(row[1]);
                            columnsLoaded = true;
                        } //else throw new CsvException("Bad format of csv file: " + filename);
                    }
                }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return new CSVData(columnsNames, data);
    }



}
