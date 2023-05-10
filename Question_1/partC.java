import java.io.*;
import java.util.*;

public class partC {
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

        // call the iterative method to find the largest value in the weight column
        int max = findMax(data, 2);
        System.out.println("Largest value in the weight column is " + max + ".");
    }

    // iterative method to find the largest value in a specific column in the CSV file
    public static int findMax(List<String[]> data, int colIndex) {
        int max = Integer.MIN_VALUE;
        for (String[] row : data) {
            if (row.length > colIndex) {
                try {
                    int num = Integer.parseInt(row[colIndex]);
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                    // ignore non-numeric values in the column
                }
            }
        }

        return max;
    }
}