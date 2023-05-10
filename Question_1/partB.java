import java.io.*;
import java.util.*;

public class partB {
    public static void main(String[] args) {
        String file = "Stock.csv";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // call the recursive method to compute the sum of column 2 (weight column)
        int sum = computeColumnSum(data, 2);
        System.out.println("Sum of column 2: " + sum);
    }

    // recursive method to compute the sum of a specific column in the CSV file
    public static int computeColumnSum(List<String[]> data, int colIndex) {
        int sum = 0;
        for (String[] row : data) {
            if (row.length > colIndex) {
                try {
                    int num = Integer.parseInt(row[colIndex]);
                    sum += num;
                } catch (NumberFormatException e) {
                    // ignore non-numeric values in the column
                }
            }
        }

        return sum;
    }
}