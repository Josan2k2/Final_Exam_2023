import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ReadStockData {
    public static void main(String[] args) throws Exception {
        // parsing and reading the CSV file data into the stock (object) array
        // with a Buffered reader
        // provide the path here...
        File file = new File("Stock.csv");

        //Question 1 part A
        BufferedReader br = new BufferedReader(new FileReader(file));
        Stock[] stocks = new Stock[1000];

        // this will just print the header in CSV file
        br.readLine();

        int i = 0;
        String st = "";

        while ((st = br.readLine()) != null) {
            String[] data = st.split(",");
            stocks[i++] = new Stock(Integer.parseInt(data[0]), Float.parseFloat(data[1]),
                            Float.parseFloat(data[2]), data[3], Float.parseFloat(data[4]), data[5]);
        }
        br.close();

        // We can print stock details due to overridden toString method in stock class
        System.out.println(stocks[0]);
        System.out.println(stocks[1]);

        // Allow the user to sort based on any column using Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter column to sort by (stockNo, stockSize, profit, weight, productName, productType): ");
        String column = input.nextLine().trim();

        //Question 1 part D
        System.out.print("Sort in ascending (A) or descending (D) order? ");
        String order = input.nextLine().trim();

        input.close();

        //Question 1 part E
        int numThreads = 6; // 6 columns to sort
        Thread[] threads = new Thread[numThreads];

        for (int j = 0; j < numThreads; j++) {
            String fileName = column + "-" + j + ".csv";
            threads[j] = new Thread(new SortTask(stocks, fileName, j, numThreads, column, order));
            threads[j].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Read the sorted files and combine them into one sorted list
        Stock[] sortedStocks = new Stock[1000];
        int index = 0;

        for (int j = 0; j < numThreads; j++) {
            String fileName = column + "-" + j + ".csv";
            BufferedReader brSorted = new BufferedReader(new FileReader(fileName));
            brSorted.readLine();

            while ((st = brSorted.readLine()) != null) {
                String[] data = st.split(",");
                sortedStocks[index++] = new Stock(Integer.parseInt(data[0]), Float.parseFloat(data[1]),
                        Float.parseFloat(data[2]), data[3], Float.parseFloat(data[4]), data[5]);
            }
            brSorted.close();
        }

        // Print out the sorted list
        for (Stock s : sortedStocks) {
            if (s != null) {
                System.out.println(s);
            }
        }

        //Question 1 part B
        float totalWeight = sumWeight(stocks, 0);
        System.out.println("Total weight: " + totalWeight);

        //Question 1 part C
        float largestValue = findLargestValue(stocks, column);
        System.out.println("Largest value in column " + column + ": " + largestValue);
    }

    private static class SortTask implements Runnable {
        private final Stock[] stocks;
        private final String fileName;
        private final int start;
        private final int step;
        private final String column;
        private final String order;

        public SortTask(Stock[] stocks, String fileName, int start, int step, String column, String order) {
            this.stocks = stocks;
            this.fileName = fileName;
            this.start = start;
            this.step = step;
            this.column = column;
            this.order = order;
        }

        public void run() {
            switch (column) {
                case "stockNo":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> o1.getStockNo() - o2.getStockNo());
                    break;
                case "stockSize":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> Float.compare(o1.getStockSize(), o2.getStockSize()));
                    break;
                case "profit":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> Float.compare(o1.getProfit(), o2.getProfit()));
                    break;
                case "weight":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> Float.compare(o1.getWeight(), o2.getWeight()));
                    break;
                case "productName":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));
                    break;
                case "productType":
                    Arrays.sort(stocks, start, stocks.length, (o1, o2) -> o1.getProductType().compareTo(o2.getProductType()));
                    break;
                default:
                    System.out.println("Invalid column name.");
            }

            // Sort in descending order if user input is "D"
            if (order.equals("D")) {
                int length = Math.min(start + step, stocks.length);
                Stock[] reversed = Arrays.copyOfRange(stocks, start, length);
                for (int i = 0; i < reversed.length / 2; i++) {
                    Stock temp = reversed[i];
                    reversed[i] = reversed[reversed.length - 1 - i];
                    reversed[reversed.length - 1 - i] = temp;
                }
                System.arraycopy(reversed, 0, stocks, start, reversed.length);
            }

            // Write to file
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)));

                writer.println("Stock No,Stock Size,Profit,Product Type,Weight,Product Name");

                for (int i = start; i < stocks.length; i += step) {
                    if (stocks[i] != null) {
                        writer.println(stocks[i].toCSV());
                    }
                }

                // Close the writer
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static float sumWeight(Stock[] stocks, int index) {
        if (index == stocks.length) {
            return 0;
        } else {
            return stocks[index].getWeight() + sumWeight(stocks, index + 1);
        }
    }

    private static float findLargestValue(Stock[] stocks, String column) {
        float largestValue = Float.MIN_VALUE; // initialize to smallest possible value
        switch (column) {
            case "stockNo":
                for (Stock s : stocks) {
                    if (s.getStockNo() > largestValue) {
                        largestValue = s.getStockNo();
                    }
                }
                break;
            case "stockSize":
                for (Stock s : stocks) {
                    if (s.getStockSize() > largestValue) {
                        largestValue = s.getStockSize();
                    }
                }
                break;
            case "profit":
                for (Stock s : stocks) {
                    if (s.getProfit() > largestValue) {
                        largestValue = s.getProfit();
                    }
                }
                break;
            case "weight":
                for (Stock s : stocks) {
                    if (s.getWeight() > largestValue) {
                        largestValue = s.getWeight();
                    }
                }
                break;
            default:
                System.out.println("Invalid column name.");
        }
        return largestValue;
    }
}

class Stock {
    private final int stockNo;
    private final float stockSize;
    private final float profit;
    private final String productType;
    private final float weight;
    private final String productName;

    public Stock(int stockNo, float stockSize, float profit, String productType, float weight, String productName) {
        this.stockNo = stockNo;
        this.stockSize = stockSize;
        this.profit = profit;
        this.productType = productType;
        this.weight = weight;
        this.productName = productName;
    }

    public int getStockNo() {
        return stockNo;
    }

    public float getStockSize() {
        return stockSize;
    }

    public float getProfit() {
        return profit;
    }

    public float getWeight() {
        return weight;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public String toString() {
        return "Stock [StockNo=" + getStockNo() + ", Stock size=" + getStockSize() + ", Profit=" + getProfit() + ", Product Type=" + getProductType() +
                ", Weight=" + getWeight() + ", Product Name=" + getProductName() + "]";
    }

    public String toCSV() {
        return getStockNo() + "," + getStockSize() + "," + getProfit() + "," + getProductType() + "," + getWeight() + "," + getProductName();
    }
}