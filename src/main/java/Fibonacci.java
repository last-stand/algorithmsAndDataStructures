public class Fibonacci {
    private static long[] fibonacciCache;

    public static long finbonacci(int number) {
        if (number <= 1) {
            return number;
        }
        if (fibonacciCache[number] != 0) {
            return fibonacciCache[number];
        }
        long fibo = finbonacci(number - 1) + finbonacci(number - 2);
        fibonacciCache[number] = fibo;
        return fibo;
    }

    public static void printFibonacci(int number) {
        fibonacciCache = new long[number + 1];
        for (int i=0; i <= number; i++) {
            System.out.print(finbonacci(i) + " ");
        }
    }

    public static void main(String[] args) {
        Fibonacci.printFibonacci(10);
    }
}
