import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static List<Integer> bubbleSort(List<Integer> arr) {
        int numSwap = 0;
        int loopCount = 0; // just to check optimize and unoptimized number of loops
        for (int i = 0; i < arr.size() - 1; i++) {
            int iterationSwapCount = 0;
            for (int j = 0 ; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    iterationSwapCount++;
                }
                loopCount++;
            }
            numSwap += iterationSwapCount;
            if (iterationSwapCount == 0) { // Optimize bubble sort algo
                break;
            }
        }
        System.out.printf("Number of loops: %d\n", loopCount);
        System.out.printf("Array is sorted in %d swaps.\n", numSwap);
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(bubbleSort(a1));

        System.out.println();

        List<Integer> a2 = Arrays.asList(1, 3, 9, 6, 4, 2, 7, 45, 31);
        System.out.println(bubbleSort(a2));
    }
}
