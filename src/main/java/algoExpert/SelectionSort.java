package algoExpert;

import helpers.Helpers;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int smallestIndex = i;
            while(j < array.length) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
                j++;
            }
            if (smallestIndex != i) {
                int temp = array[i];
                array[i] = array[smallestIndex];
                array[smallestIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        selectionSort(input1);
        for (int i = 0; i < input1.length; i++) {
            System.out.print(input1[i] + " ");
        }

        System.out.println();

        int[] input2 = {8, 5, 2, 9, 5, 6, 3};
        selectionSort(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " ");
        }

        int[] input3 = Helpers.generateRandomIntegers(10000, 100000);
        System.out.println("\nBefore:");
        Helpers.printArray(input3);

        selectionSort(input3);

        System.out.println("\nAfter:");
        Helpers.printArray(input3);
    }
}
