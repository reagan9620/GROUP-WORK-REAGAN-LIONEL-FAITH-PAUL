import java.util.Scanner;

public class IterativeFibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter maximum position (0-92): ");
        int n = input.nextInt();

        if (n < 0 || n > 92) {
            System.out.println("Invalid input!");
            input.close();
            return;
        }

        long[] fib = new long[n + 1];

        if (n >= 1) {
            fib[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("Fibonacci series:");

        for (int i = 0; i <= n; i++) {
            System.out.print(fib[i] + " ");
        }

        System.out.println();
        input.close();
    }
}