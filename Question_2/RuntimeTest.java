import java.util.Arrays;
import java.util.LinkedList;

//part F
public class RuntimeTest {

    public static void main(String[] args) {

        // Test retrieving the last item from a data structure

        int[] arr = {1, 2, 3, 4, 5};
        long start = System.nanoTime();
        int lastItem = arr[arr.length - 1];
        long end = System.nanoTime();
        System.out.println("Unsorted array: " + (end - start) + " nanoseconds");

        int[] sortedArr = {1, 2, 3, 4, 5};
        start = System.nanoTime();
        lastItem = sortedArr[sortedArr.length - 1];
        end = System.nanoTime();
        System.out.println("Sorted array: " + (end - start) + " nanoseconds");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        start = System.nanoTime();
        lastItem = linkedList.getLast();
        end = System.nanoTime();
        System.out.println("Linked list: " + (end - start) + " nanoseconds");

        // Test inserting an item into a data structure

        arr = new int[]{1, 2, 4, 5};
        int newItem = 3;
        int insertIndex = 2;
        start = System.nanoTime();
        for (int i = arr.length - 1; i > insertIndex; i--) {
            arr[i] = arr[i-1];
        }
        arr[insertIndex] = newItem;
        end = System.nanoTime();
        System.out.println("Unsorted array: " + (end - start) + " nanoseconds");

        sortedArr = new int[]{1, 2, 4, 5};
        newItem = 3;
        start = System.nanoTime();
        insertIndex = Arrays.binarySearch(sortedArr, newItem);
        if (insertIndex < 0) {
            insertIndex = -(insertIndex + 1);
        }
        for (int i = sortedArr.length - 1; i > insertIndex; i--) {
            sortedArr[i] = sortedArr[i-1];
        }
        sortedArr[insertIndex] = newItem;
        end = System.nanoTime();
        System.out.println("Sorted array: " + (end - start) + " nanoseconds");

        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        start = System.nanoTime();
        Node newNode = new Node(4);
        newNode.next = linkedList.head;
        linkedList.head = newNode;
        end = System.nanoTime();
        System.out.println("Linked list: " + (end - start) + " nanoseconds");

        // Test retrieving an item at a specific index within a data structure

        arr = new int[]{2, 5, 1, 9, 7};
        int index = 2;
        start = System.nanoTime();
        int element = arr[index];
        end = System.nanoTime();
        System.out.println("Unsorted array: " + (end - start) + " nanoseconds");

        arr = new int[]{1, 2, 5, 7, 9};
        index = 2;
        start = System.nanoTime();
        element = arr[index];
        end = System.nanoTime();
        System.out.println("Sorted array: " + (end - start) + " nanoseconds");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(7);
        index = 2;
        start = System.nanoTime();
        element = list.get(index);
        end = System.nanoTime();
        System.out.println("Linked list: " + (end - start) + " nanoseconds");

        // Test retrieving the index of the minimum value in a data structure

        arr = new int[]{2, 5, 1, 9, 7};
        start = System.nanoTime();
        int minIndex = findMinIndex(arr);
        end = System.nanoTime();
        System.out.println("Unsorted array: " + (end - start) + " nanoseconds");

        arr = new int[]{1, 2, 5, 7, 9};
        start = System.nanoTime();
        minIndex = findMinIndex(arr);
        end = System.nanoTime();
        System.out.println("Sorted array: " + (end - start) + " nanoseconds");

        list = new LinkedList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(7);
        start = System.nanoTime();
        minIndex = findMinIndex(list);
        end = System.nanoTime();
        System.out.println("Linked list: " + (end - start) + " nanoseconds");

        // Test searching for a specific item and its index in a data structure

        arr = new int[]{2, 5, 1, 9, 7};
        int target = 1;
        start = System.nanoTime();
        index = findIndexInUnsortedArray(arr, target);
        end = System.nanoTime();
        System.out.println("Unsorted array: " + (end - start) + " nanoseconds");

        arr = new int[]{1, 2, 5, 7, 9};
        target = 5;
        start = System.nanoTime();
        index = findIndexInSortedArray(arr, target);
        end = System.nanoTime();
        System.out.println("Sorted array: " + (end - start) + " nanoseconds");

        list = new LinkedList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(7);
        target = 9;
        start = System.nanoTime();
        index = findIndexInLinkedList(list, target);
        end = System.nanoTime();
        System.out.println("Linked list: " + (end - start) + " nanoseconds");
    }

    static int findMinIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int findMinIndex(LinkedList<Integer> list) {
        int minIndex = 0;
        int minValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < minValue) {
                minIndex = i;
                minValue = list.get(i);
            }
        }
        return minIndex;
    }

    static int findIndexInUnsortedArray(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int findIndexInSortedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    static int findIndexInLinkedList(LinkedList<Integer> list, int target) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
