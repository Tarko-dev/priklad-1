package me.jmatura.priklad1;

import me.jmatura.priklad1.CSVData;
import me.jmatura.priklad1.CSVLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {

    @Test
    void testLoadCSV() {

        String testFileName = "movies.txt";
        CSVLoader dataLoader = new CSVLoader();

        CSVData csvData = dataLoader.loadCSV(testFileName);

        assertNotNull(csvData);
        assertEquals(2, csvData.getColumnsNames().size());
        assertEquals(4, csvData.getData().size());
        assertEquals(90, csvData.getData().get("Terminator 2"));
    }
}