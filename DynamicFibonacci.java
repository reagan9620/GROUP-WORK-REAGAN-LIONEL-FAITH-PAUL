import java.util.Scanner;

public class DynamicFibonacci {

    static long[] fibonacciDP(int n) {
        long[] dp = new long[n + 1];

        if (n >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter maximum position (0-92): ");
        int n = input.nextInt();

        if (n < 0 || n > 92) {
            System.out.println("Invalid input!");
            input.close();
            return;
        }

        long[] result = fibonacciDP(n);

        System.out.println("Fibonacci series using DP:");

        for (int i = 0; i <= n; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        input.close();
    }
}