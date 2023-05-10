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