package algoExpert;

import helpers.Helpers;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while(j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        insertionSort(input1);
        for (int i = 0; i < input1.length; i++) {
            System.out.print(input1[i] + " ");
        }

        System.out.println();

        int[] input2 = {8, 5, 2, 9, 5, 6, 3};
        insertionSort(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " ");
        }

        int[] input3 = Helpers.generateRandomIntegers(10000, 100000);
        System.out.println("\nBefore:");
        Helpers.printArray(input3);

        insertionSort(input3);

        System.out.println("\nAfter:");
        Helpers.printArray(input3);
    }
}
