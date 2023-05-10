# Final TABA 2023
 Algorithms and Advance Programming

Intructions and answers:

1	Question 1: 
Using a data file you have not previously worked on for the CA (either staff.csv, stock.csv, or films.csv), complete the following tasks. A java application should be written to complete the following tasks (these can be separate applications or just a single one).
The answers for the following questions are as a single code within the zip file under the file name Question_1.
a)	Read a CSV file into memory using the Buffered reader (note the original way to read these files in the provided code for the CA used the Scanner class instead of buffered reader).

b)	Write a recursive method to compute the sum of either the wage, weight, or length column, depending on whether you have read the staff.csv, stock.csv, or films.csv respectively.    

c)	Write an iterative method to find the largest value in the respective column from part b). 

d)	Write a sorting method for all possible columns in the data file. Your application should allow the user the option to sort the array using any column (This can be done through either the Scanner class or using the swing windowing library). 

e)	Create a multi-threaded solution, where each thread sorts a copy of the data in a different order depending on the column being sorted, i.e., thread 1: sorts based on column 1, thread 2: sorts based on column 2, and so on. A copy of each order should be saved to a different file. For example, if sorting the films file based on column 1 save it as sortedFilms_C1.csv (it doesn’t have to be csv, it can be whatever file format you choose). 

2	Question 2
Consider what the Big O run-time complexity would be for an unsorted array, sorted array, and linked list for each of the following tasks (explain your reasoning):  (Reference Arrays, Linked Lists, and Big O Notation)
a)	Retrieving the last item from this data structure.
The time complexity of retrieving the last item from a data structure depends on the specific implementation of the data structure. Here are the Big O run-time complexities for retrieving the last item from an unsorted array, a sorted array, and a singly linked list:

import java.util.ArrayList;
import java.util.LinkedList;

public class partA {

    public static void main(String[] args) {
        int[] unsortedArray = {4, 2, 6, 8, 1, 7};
        int[] sortedArray = {1, 2, 4, 6, 7, 8};
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        System.out.println("Time complexity of retrieving last item from:");
        System.out.println("Unsorted array: " + retrieveFromUnsortedArray(unsortedArray));
        System.out.println("Sorted array: " + retrieveFromSortedArray(sortedArray));
        System.out.println("Singly Linked List: " + retrieveFromSinglyLinkedList(linkedList));
    }

    public static int retrieveFromUnsortedArray(int[] array) {
        return array[array.length - 1]; // Time complexity: O(1)
    }

    public static int retrieveFromSortedArray(int[] array) {      
        return array[array.length - 1]; // Time complexity: O(1)
    }

    public static int retrieveFromSinglyLinkedList(LinkedList<Integer> linkedList) {
        return linkedList.getLast(); // Time complexity: O(1)
    }
}


b)	Inserting an item into this data structure.
The time it takes to insert an item into a data structure depends on the amount of data and how it's organized. To measure this time complexity, programmers use Big O notation, which tells us how much time algorithms take as input size grows. Let's say a simple algorithm takes 1 second to execute for an input of 10; it doesn't mean it will necessarily take 10 seconds for input size 100, as we can optimize our code. But if the algorithm takes twice as long to execute for every doubling in input size, its time complexity is O(n). This notation helps optimize code for better performance as input size grows.

import java.util.ArrayList;
import java.util.LinkedList;

public class partB {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] array = new int[100000];

        long start, end;

        // Testing inserting an item into the ArrayList
        start = System.nanoTime();
        arrayList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an ArrayList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into a LinkedList
        start = System.nanoTime();
        linkedList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into a LinkedList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into an array
        start = System.nanoTime();
        array[array.length - 1] = 1; // Adding at end of array
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an Array: " + (end - start) + " nanoseconds");
    }
}

c)	Retrieving an item at a specific index within this data structure.
The time complexity for retrieving an item at a specific index from an array depends on whether it's sorted or not. If it's unsorted, we may have to search the whole array. If it's sorted, we can use the index directly. For linked lists, we need to traverse the list to get to the desired index, regardless of whether it's sorted or not.

import java.util.ArrayList;
import java.util.LinkedList;

public class partC {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] array = new int[100000];

        long start, end;

        // Testing inserting an item into the ArrayList
        start = System.nanoTime();
        arrayList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an ArrayList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into a LinkedList
        start = System.nanoTime();
        linkedList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into a LinkedList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into an array
        start = System.nanoTime();
        array[array.length - 1] = 1; // Adding at end of array
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an Array: " + (end - start) + " nanoseconds");

        // Retrieving an item at a specific index in ArrayList
        start = System.nanoTime();
        int valueFromArrayList = arrayList.get(0); // Retrieving the first element
        end = System.nanoTime();
        System.out.println("Time taken to retrieve an item at a specific index in ArrayList: " + (end - start) + " nanoseconds");

        // Retrieving an item at a specific index in LinkedList
        start = System.nanoTime();
        int valueFromLinkedList = linkedList.get(0); // Retrieving the first element
        end = System.nanoTime();
        System.out.println("Time taken to retrieve an item at a specific index in LinkedList: " + (end - start) + " nanoseconds");

        // Retrieving an item at a specific index in array
        start = System.nanoTime();
        int valueFromArray = array[0]; // Retrieving the first element
        end = System.nanoTime();
        System.out.println("Time taken to retrieve an item at a specific index in array: " + (end - start) + " nanoseconds");
    }
}

d)	Retrieving the index of the minimum value in the data structure.
The time for finding the index of the minimum value depends on whether the data structure is sorted or not. If it's unsorted or a linked list, we need to iterate through the whole data structure to find the minimum value. If it's sorted, we know that the minimum value is at the first index, so we don't need to search.

import java.util.ArrayList;
import java.util.LinkedList;

public class partD {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] array = new int[100000];

        long start, end;

        // Testing inserting an item into the ArrayList
        start = System.nanoTime();
        arrayList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an ArrayList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into a LinkedList
        start = System.nanoTime();
        linkedList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into a LinkedList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into an array
        start = System.nanoTime();
        array[array.length - 1] = 1; // Adding at end of array
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an Array: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in ArrayList
        arrayList.add(5);
        arrayList.add(1);
        start = System.nanoTime();
        int indexOfMinValueInArrayList = arrayList.indexOf(arrayList.stream().min(Integer::compare).get());
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in ArrayList: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in LinkedList
        linkedList.add(5);
        linkedList.add(1);
        start = System.nanoTime();
        int indexOfMinValueInLinkedList = linkedList.indexOf(linkedList.stream().min(Integer::compare).get());
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in LinkedList: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in array
        array[0] = 5;
        array[1] = 1;
        start = System.nanoTime();
        int minValueInArray = Integer.MAX_VALUE, indexOfMinValueInArray = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValueInArray) {
                minValueInArray = array[i];
                indexOfMinValueInArray = i;
            }
        }
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in array: " + (end - start) + " nanoseconds");
    }
}



e)	Searching for a specific item and its respective index in that data structure. 
In simple terms, the time complexity for searching for a specific item and its index depends on whether the data structure is sorted or not. If it's sorted, we can use binary search to find the item and its index in O time. If it's unsorted or a linked list, we need to iterate through the whole data structure to find the item and its index in O time:

import java.util.ArrayList;
import java.util.LinkedList;

public class partE {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] array = new int[100000];

        long start, end;

        // Testing inserting an item into the ArrayList
        start = System.nanoTime();
        arrayList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an ArrayList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into a LinkedList
        start = System.nanoTime();
        linkedList.add(1);
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into a LinkedList: " + (end - start) + " nanoseconds");

        // Testing inserting an item into an array
        start = System.nanoTime();
        array[array.length - 1] = 1; // Adding at end of array
        end = System.nanoTime();
        System.out.println("Time taken to insert a new item into an Array: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in ArrayList
        arrayList.add(5);
        arrayList.add(1);
        start = System.nanoTime();
        int indexOfMinValueInArrayList = arrayList.indexOf(arrayList.stream().min(Integer::compare).get());
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in ArrayList: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in LinkedList
        linkedList.add(5);
        linkedList.add(1);
        start = System.nanoTime();
        int indexOfMinValueInLinkedList = linkedList.indexOf(linkedList.stream().min(Integer::compare).get());
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in LinkedList: " + (end - start) + " nanoseconds");

        // Finding index of the minimum value in array
        array[0] = 5;
        array[1] = 1;
        start = System.nanoTime();
        int minValueInArray = Integer.MAX_VALUE, indexOfMinValueInArray = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValueInArray) {
                minValueInArray = array[i];
                indexOfMinValueInArray = i;
            }
        }
        end = System.nanoTime();
        System.out.println("Time taken to find the index of the minimum value in array: " + (end - start) + " nanoseconds");

         // Searching for a specific item in ArrayList and getting its index
        start = System.nanoTime();
        int indexInArrayList = arrayList.indexOf(5);
        end = System.nanoTime();
        System.out.println("Time taken to find the index of 5 in ArrayList: " + (end - start) + " nanoseconds");

        // Searching for a specific item in LinkedList and getting its index
        start = System.nanoTime();
        int indexInLinkedList = linkedList.indexOf(5);
        end = System.nanoTime();
        System.out.println("Time taken to find the index of 5 in LinkedList: " + (end - start) + " nanoseconds");

        // Searching for a specific item in array and getting its index
        start = System.nanoTime();
        int indexInArray = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                indexInArray = i;
                break;
            }
        }
        end = System.nanoTime();
        System.out.println("Time taken to find the index of 5 in array: " + (end - start) + " nanoseconds");
    }
}

f)	How could you test the run-time of these algorithms and their respective data structures in a real system on your own personal machine? You can provide examples as well as a description if this helps.

To test the runtime of algorithms you can use a profiler tool such as VisualVM, YourKit or JProfiler. These tools can provide information on the execution time of each method in addition to memory usage, CPU usage, and other performance statistics. To use these tools, you'll need to deploy your application on a local server and then connect it to the profiler tool. Once that is done, you can execute the methods and observe the performance statistics. 

Additionally, you could write test cases using JUnit or TestNG to measure the performance of your data structures and algorithms for different input sizes. One way to do this is to create an array of a specific size and measure the time it takes to perform different operations such as inserting and retrieving items. 

Overall, testing and profiling can help you identify performance issues and guide the selection of the best data structure and algorithm for the task at hand.

3	Question 3
a)	Discuss in your own words the following with respect to multi-threading. Locks, deadlock, starvation, and synchronization. Provide example of when each may be appropriate or can occur (i.e., when to use locks and synchronization, and what causes deadlocks and starvation). 

Multithreading is a way to run multiple threads at the same time within a single process. However, there are some important concepts to understand when working with multithreading. Here are a few:

•	Locks: Locks are used to allow multiple threads to access shared resources without interfering with each other. This means that one thread can access a shared resource, use it, and release it so that another thread can access it safely. Locks are important for ensuring that only one thread can execute a critical section of code at a time. A common type of lock is a mutex, which allows only one thread to hold the lock at a time.

•	Synchronization: Synchronization helps ensure that one thread waits for another thread to finish before proceeding. This is important when multiple threads need to work together on a task. For example, if one thread is doing some work, another thread can wait until it's done before proceeding.

•	Deadlocks: Deadlocks happen when multiple threads are waiting for each other to release resources. This means that neither of the threads can proceed because they're both waiting for the other. Deadlocks can happen when there's a cyclic dependency between threads. For example, if thread A needs a resource that's held by thread B, and thread B needs a resource that's held by thread A, they'll both be stuck waiting for each other, resulting in a deadlock.

•	Starvation: Starvation happens when a thread isn't given the opportunity to run because other threads are hogging resources or because it's a low-priority thread. This means that the thread might wait indefinitely and never complete its task. For example, if a high-priority thread is running all the time, lower-priority threads might never get a chance to run and be starved.

b)	What are possible solutions to deadlock and starvation?
Deadlocks occur when two or more threads need resources that are locked by each other. For example, if thread A needs a resource that's locked by thread B, and thread B needs a resource that's locked by thread A, both threads will wait indefinitely, leading to a deadlock.

Starvation occurs when a thread is not given the chance to run because other threads are hogging all resources. For example, if a high-priority thread keeps running indefinitely, lower-priority threads may be starved and never have a chance to run.

4	Question 4
a)	Memorization and dynamic programming can help reduce the run-time complexity of certain problems when they involve repeating a number of sub-problems. Explain this and include an example that illustrates the effectiveness of these types of solutions. 

•	Memorization remembers answers to repeated subproblems, while Dynamic Programming computes the solution to each sub-problem once and saves the result for later use. This technique reduces the algorithm's time complexity by eliminating repetitive computations. For instance, finding the nth Fibonacci number recursively computes the same numbers multiple times, which is inefficient. Using memorization or dynamic programming can help reduce runtime complexity and make it more efficient.

Example of how to use dynamic programming to calculate the nth Fibonacci number in java:
public class partA {

    static int[] fib = new int[101];

    public static void main(String[] args) {

        int n = 10;

        System.out.println(fibonacci(n));

    }

    static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else if (fib[n] != 0) {
            return fib[n];
        } else {
            return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

b)	Given multiple arrays of numbers, remove any multiples of 5. Then sort each of the arrays and their remaining numbers. The final output should contain each of the sorted arrays printed in the order of their final length. The input to this problem will be an integer representing the number of arrays and then the respective arrays (all of which will contain integers).

Example input:
3
[98, 6, 2]
[5, 6, 7, 4, 10, 1]
[10, 20, 2, 3]

Example output:
[1, 4, 6, 7]
[2, 6, 98]
[2, 3]

Java code representation:

import java.util.*; 

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

public class partB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of arrays: ");
        int numArrays = scanner.nextInt();

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < numArrays; i++) {
            System.out.print("Enter the size of array #" + (i+1) + ": ");
            int size = scanner.nextInt();

            int[] array = new int[size];
            System.out.print("Enter the elements of array #" + (i+1) + ": ");
            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }

            // Remove multiples of 5 from the array
            array = Arrays.stream(array)
                    .filter(num -> num % 5 != 0)
                    .toArray();

            // Sort the array
            Arrays.sort(array);

            // Add array to the list of arrays
            arrays.add(array);
        }

        // Sort the list of arrays by final length
        Collections.sort(arrays, Comparator.comparingInt(array -> array.length));

        // Print out the sorted arrays
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}

c)	How would you improve your solution for part b) with multi-threading? Write a java application to do this.

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

        // Print the sorted arrays
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}

d)	Will multi-threading always improve performance? How would you test this?

So, the thing about multi-threading is that it's not always the best solution for making an application faster. Sometimes it can actually make things slower, especially if multiple threads are accessing the same data or resources at the same time - this can cause some clashes and race conditions. So, if we want to see how multi-threading impacts the performance of an application, we need to conduct something called a benchmark test. This test involves comparing how long it takes different numbers of threads to complete the same task. In order to get accurate and consistent results, we need to make sure the test is repeatable. By comparing the results of this test between single-threaded and multi-threaded code, we can see if using more threads actually improves performance and how many threads are needed to get the best performance.
