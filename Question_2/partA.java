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