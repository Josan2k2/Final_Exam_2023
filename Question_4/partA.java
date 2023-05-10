public class partA {

    static int[] fib = new int[101];

    public static void main(String[] args) {

        int n = 10;

        System.out.println(fibonacci(n));

    }

    static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else if (fib[n] != 0) {
            return fib[n];
        } else {
            return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
