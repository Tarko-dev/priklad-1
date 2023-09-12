import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {

    @Test
    void testLoadCSV() {
        // Assuming you have a sample CSV file "test.csv" with data for testing

        // Replace with the actual file path to your test CSV file
        String testFileName = "path/to/your/test.csv";
        CSVLoader dataLoader = new CSVLoader();

        // Load CSV data using the method
        CSVData csvData = dataLoader.loadCSV(testFileName);

        // Perform assertions to validate the results
        assertNotNull(csvData);
        assertEquals(2, csvData.getColumnsNames().size()); // Assuming two columns are expected
        assertEquals(2, csvData.getData().size()); // Assuming two rows of data are expected

        // Add more specific assertions as needed to validate the loaded data
    }
}