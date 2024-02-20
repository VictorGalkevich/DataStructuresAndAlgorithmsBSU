import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solver(a, b));
    }

    public static String solver(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int len = dp[a.length][b.length];
        int k = len - 1;
        int[] ares = new int[len];
        int[] bres = new int[len];
        int ci = dp.length - 1;
        int cj = dp[0].length - 1;
        while (dp[ci][cj] > 0) {
            while (dp[ci][cj - 1] == dp[ci][cj]) {
                cj--;
            }
            while (dp[ci - 1][cj] == dp[ci][cj]) {
                ci--;
            }
            if (k >= 0) {
                ares[k] = ci - 1;
                bres[k] = cj - 1;
            }
            k--;
            ci--;
            cj--;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(len).append("\n");
        for (int i = 0; i < len; i++) {
            builder.append(ares[i]).append(" ");
        }
        builder.append("\n");
        for (int i = 0; i < len; i++) {
            builder.append(bres[i]).append(" ");
        }
        return builder.toString().trim();
    }
}
