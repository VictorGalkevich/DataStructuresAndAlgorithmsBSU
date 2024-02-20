import java.util.Scanner;

public class OnesOne {
    private static final int MODULO = 1_000_000_000 + 7;
    private static long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        System.out.println(solver(n, k));
    }

    public static long solver(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        if (k == 1 || n == k - 1) {
            return n;
        }
        if (dp[n - 1][k] == 0) {
            dp[n - 1][k] = solver(n - 1, k);
        }
        if (dp[n - 1][k - 1] == 0) {
            dp[n - 1][k - 1] = solver(n - 1, k - 1);
        }
        return (dp[n - 1][k] + dp[n - 1][k - 1]) % MODULO;
    }
}
