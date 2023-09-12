import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVData {

    private final List<String> columnsNames;
    private final Map<String, Integer> data;
    private final List<Integer> values;

    public CSVData(List<String> columnsNames, Map<String, Integer> data) {
        this.columnsNames = columnsNames;
        this.data = data;
        this.values = data.values().stream().sorted().collect(Collectors.toList());
    }

    public List<String> getColumnsNames() {
        return columnsNames;
    }

    public Map<String, Integer> getData() {
        return data;
    }

    /**
     * Finds and returns the key associated with the highest-rated value in the data.
     *
     * @return The key corresponding to the highest-rated value, or null if the data is empty.
     */
    public String highestRatedKey() {
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (Objects.equals(entry.getValue(), values.get(0))) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Finds and returns the key associated with the lowest-rated value in the data.
     *
     * @return The key corresponding to the lowest-rated value, or null if the data is empty.
     */
    public String lowestRatedKey() {
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (Objects.equals(entry.getValue(), values.get(values.size() - 1))) {
                return entry.getKey();
            }
        }
        return null;
    }


    /**
     * Calculates and returns the average of all the values in the data.
     *
     * @return The average of the values, or -1 if the data is empty.
     */
    public long average() {
        if (values.size()==0){
            return -1;
        }
        int sum = values.stream().mapToInt(number -> number).sum();
        return sum/values.size();
    }


    /**
     * Returns the number of values in the data.
     *
     * @return The number of values in the data.
     */
    public int size(){
        return values.size();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(columnsNames)
                .append(data);
        return stringBuilder.toString();
    }
}
