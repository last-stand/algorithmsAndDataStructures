import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=GuTPwotSdYw
public class Permutations {
    static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return  String.valueOf(charArray);
    }

    /* Function to print permutations of string
        This function takes three parameters:
        str String
        left Starting index of the string
        right Ending index of the string.
    */
    static void getPermutation(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                String swapped = swap(str, left, i);
                getPermutation(swapped, left + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        int n = str.length();
        getPermutation(str, 0, n - 1);
    }
}
