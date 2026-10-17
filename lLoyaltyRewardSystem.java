import java.util.Scanner;

public class LoyaltyRewardSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println(" CUSTOMER LOYALTY REWARD SYSTEM");
        System.out.println("================================");

        System.out.print("Enter loyalty years (1-93): ");
        int years = input.nextInt();

        if (years < 1 || years > 93) {
            System.out.println("Invalid number of years!");
            input.close();
            return;
        }

        long[] rewards = new long[years];

        // Year 1 receives 0 points
        rewards[0] = 0;

        // Year 2 receives 1 point
        if (years >= 2) {
            rewards[1] = 1;
        }

        // Generate rewards using the Fibonacci sequence
        for (int i = 2; i < years; i++) {
            rewards[i] = rewards[i - 1] + rewards[i - 2];
        }

        System.out.println("\nYEAR\tREWARD POINTS");
        System.out.println("------------------------");

        for (int i = 0; i < years; i++) {
            System.out.println((i + 1) + "\t" + rewards[i]);
        }

        System.out.println("------------------------");
        System.out.println("Reward schedule generated!");

        input.close();
    }
}