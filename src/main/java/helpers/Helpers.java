package helpers;

import java.util.Random;

public class Helpers {
    public static int[] generateRandomIntegers(int length, int max) {
        Random random = new Random();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(max);
        }
        return numbers;
    }

    public static void printArray(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i] + ", ");
        }
        System.out.println(stringBuilder.toString());
    }
}
