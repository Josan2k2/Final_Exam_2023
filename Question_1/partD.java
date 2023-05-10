import java.io.*;
import java.util.*;

public class partD {
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

        // prompt the user to select the column to sort by
        Scanner scanner = new Scanner(System.in);

        /*
        * For test purpose only, the index numbers and names are as follow:
        * 0. Stock no
        * 1. Product size
        * 2. Profit
        * 3. Product type
        * 4. Weight
        * 5. Product name
        */
        
        System.out.print("Enter the column number (starting from 0): ");
        int colIndex = scanner.nextInt();
        scanner.close();

        // call the sorting method and print the sorted list to the console
        List<String[]> sortedData = sortData(data, colIndex);
        for (String[] row : sortedData) {
            System.out.println(Arrays.toString(row));
        }
    }

    // sorting method to sort the data list by a specific column
    public static List<String[]> sortData(List<String[]> data, int colIndex) {
        Collections.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1.length > colIndex && o2.length > colIndex) {
                    return o1[colIndex].compareTo(o2[colIndex]);
                } else {
                    return 0;
                }
            }
        });

        return data;
    }
}