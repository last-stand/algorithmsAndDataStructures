package algoExpert;

public class BinarySearch {

    public static int binarySearch(int[] array, int x) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int low = 0 , high = array.length - 1;
        while (low <= high ) {
            int mid = (low + high) / 2;

            if (array[mid] == x)
                return mid;
            if (array[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursively(int[] array, int target, int low, int high) {
        if (array == null || array.length == 0 || low > high) {
            return -1;
        }
        int mid = low + high / 2;
        if (target == array[mid])
            return mid;
        if (target > array[mid]) {
            return binarySearchRecursively(array, target, mid + 1, high);
        } else {
            return binarySearchRecursively(array, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;
        int x = 5;
        int result1 = binarySearch(array, x);
        System.out.println(result1);

        int result2 = binarySearchRecursively(array, x, 0, n - 1);
        System.out.println(result2);
    }
}
