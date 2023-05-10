import java.util.*; 
import java.util.concurrent.*;

/*
 * For test purpose only:
 * Enter the number of arrays: 3
 * Enter the size of array #1: 5
 * Enter the elements of array #1: 10 5 15 20 25
 * Enter the size of array #2: 4
 * Enter the elements of array #2: 30 25 35 32
 * Enter the size of array #3: 3
 * Enter the elements of array #3: 16 55 64
 */

public class partC {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of arrays: ");
        int numArrays = scanner.nextInt();

        List<int[]> arrays = new ArrayList<>();
        List<CompletableFuture<int[]>> futures = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(numArrays);

        for (int i = 0; i < numArrays; i++) {
            System.out.print("Enter the size of array #" + (i+1) + ": ");
            int size = scanner.nextInt();

            int[] array = new int[size];
            System.out.print("Enter the elements of array #" + (i+1) + ": ");
            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }

            CompletableFuture<int[]> future = CompletableFuture.supplyAsync(() -> {
                // Remove multiples of 5 from the array
                int[] filteredArray = Arrays.stream(array)
                        .filter(num -> num % 5 != 0)
                        .toArray();

                // Sort the array
                Arrays.sort(filteredArray);
                return filteredArray;
            }, executor);

            futures.add(future);
        }

        // Wait for all futures to complete and add the resulting arrays to the list of arrays
        for (CompletableFuture<int[]> future : futures) {
            int[] array = future.get();
            arrays.add(array);
        }

        // Shutdown the executor
        executor.shutdown();

        // Sort the list of arrays by final length
        Collections.sort(arrays, Comparator.comparingInt(array -> array.length));

        // Print out the sorted arrays
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}
