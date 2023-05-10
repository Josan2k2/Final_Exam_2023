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