import java.io.*;
import java.util.*;

public class partE {
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

        // create threads to sort the data in different orders
        List<SortingThread> threads = new ArrayList<>();
        for (int i = 0; i < data.get(0).length; i++) {
            SortingThread thread = new SortingThread(data, i);
            threads.add(thread);
            thread.start();
        }

        // wait for all threads to finish sorting
        for (SortingThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SortingThread extends Thread {
    private List<String[]> data;
    private int colIndex;

    public SortingThread(List<String[]> data, int colIndex) {
        this.data = data;
        this.colIndex = colIndex;
    }

    public void run() {
        // create a sorted copy of the data list based on the selected column
        List<String[]> sortedData = sortData(data, colIndex);

        // write the sorted data to a new CSV file
        String fileName = "Stock_sorted_" + colIndex + ".csv";
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            for (String[] row : sortedData) {
                sb.append(String.join(",", row)).append("\n");
            }
            pw.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted data based on column " + colIndex + " is saved to file " + fileName + ".");
    }

    // sorting method to sort the data list by a specific column
    public List<String[]> sortData(List<String[]> data, int colIndex) {
        List<String[]> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1.length > colIndex && o2.length > colIndex) {
                    return o1[colIndex].compareTo(o2[colIndex]);
                } else {
                    return 0;
                }
            }
        });

        return sortedData;
    }
}