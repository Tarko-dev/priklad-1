package me.jmatura.priklad1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class CSVLoader {

    /**
     * Loads data from a CSV file and returns a {@link CSVData} object containing the parsed data.
     *
     * @param filename The path to the CSV file to be loaded.
     * @return A {@link CSVData} object representing the parsed CSV data.
     */
    public CSVData loadCSV(String filename){
        List<String[]> csvData;
        Map<String, Integer> data = new HashMap<>();
        List<String> columnsNames = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            csvData = reader.readAll();

            data = csvData.stream()
                    .skip(1)
                    .filter(row -> row.length == 2)
                    .collect(Collectors.toMap(row -> row[0], row -> Integer.valueOf(row[1])));

            columnsNames = Arrays.stream(csvData.stream()
                    .filter(row -> row.length==2)
                    .findFirst()
                    .get())
                    .toList();
        } catch (IOException | CsvException e) {
            log.error("Failed while trying to consume the csv: {}",e.getMessage());
        }
        return new CSVData(columnsNames, data);
    }



}
