public class FibonacciBenchmark {

    static volatile long resultSink;

    static long recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    static long iterative(int n) {
        long[] fib = new long[n + 1];

        if (n >= 1) {
            fib[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    static long dynamicProgramming(int n) {
        long[] dp = new long[n + 1];

        if (n >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static double measure(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int n = 30;

        // Warm up the Java runtime
        for (int i = 0; i < 100; i++) {
            resultSink = iterative(n);
            resultSink = dynamicProgramming(n);
        }

        double recursiveTime =
            measure(() -> resultSink = recursive(n));

        double iterativeTime =
            measure(() -> resultSink = iterative(n));

        double dpTime =
            measure(() -> resultSink = dynamicProgramming(n));

        System.out.println("FIBONACCI PERFORMANCE TEST");
        System.out.println("n = " + n);
        System.out.println("Expected result: 832040");

        System.out.printf("Recursive: %.4f ms%n", recursiveTime);
        System.out.printf("Iterative: %.4f ms%n", iterativeTime);
        System.out.printf("Dynamic programming: %.4f ms%n", dpTime);
    }
}// JavaScript source code
