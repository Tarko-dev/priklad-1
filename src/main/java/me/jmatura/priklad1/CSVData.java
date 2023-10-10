package me.jmatura.priklad1;

import lombok.Getter;

import java.util.List;
import java.util.Map;

public class CSVData {

    @Getter
    private final List<String> columnsNames;
    @Getter
    private final Map<String, Integer> data;
    private final List<Integer> values;

    public CSVData(List<String> columnsNames, Map<String, Integer> data) {
        this.columnsNames = columnsNames;
        this.data = data;
        this.values = data.values().stream()
                .sorted()
                .toList();
    }

    /**
     * Finds and returns the key associated with the highest-rated value in the data.
     *
     * @return The key corresponding to the highest-rated value, or null if the data is empty.
     */
    public String highestRatedKey() {
        return data.entrySet().stream()
                .filter(entry -> entry.getValue().equals(values.get(size()-1)))
                .map(Map.Entry::getKey)
                .toList()
                .get(0);
    }

    /**
     * Finds and returns the key associated with the lowest-rated value in the data.
     *
     * @return The key corresponding to the lowest-rated value, or null if the data is empty.
     */
    public String lowestRatedKey() {
        return data.entrySet().stream()
                .filter(entry -> entry.getValue().equals(values.get(0)))
                .findFirst()
                .get()
                .getKey();
    }


    /**
     * Calculates and returns the average of all the values in the data.
     *
     * @return The average of the values, or -1 if the data is empty.
     */
    public long average() {
        if (values.isEmpty()){
            return -1;
        }
        int sum = values.stream()
                .mapToInt(number -> number)
                .sum();
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
        return String.valueOf(columnsNames) +
                data;
    }
}
