package algoExpert;

import helpers.Helpers;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        boolean isSorted =  false;
        int counter = 0;
        while(!isSorted) {
            isSorted =  true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted =  false;
                }
            }
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        bubbleSort(input1);
        for (int i = 0; i < input1.length; i++) {
            System.out.print(input1[i] + " ");
        }

        System.out.println();

        int[] input2 = {8, 5, 2, 9, 5, 6, 3};
        bubbleSort(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " ");
        }

        int[] input3 = Helpers.generateRandomIntegers(10000, 100000);
        System.out.println("\nBefore:");
        Helpers.printArray(input3);

        bubbleSort(input3);

        System.out.println("\nAfter:");
        Helpers.printArray(input3);
    }
}
