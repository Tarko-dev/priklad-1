public class Executor {

      private static final String FILENAME = "movies.txt";

      public static void main (String[] args){

            CSVData csvData = new CSVLoader().loadCSV(FILENAME);

            System.out.println(csvData.highestRatedKey());
            System.out.println(csvData.lowestRatedKey());
            System.out.println(csvData.average());
            System.out.println(csvData.size());
            System.out.println(csvData);

      }

}
