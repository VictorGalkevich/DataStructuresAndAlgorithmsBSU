import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LevenshtainDistance {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("in.txt"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        FileWriter fw = new FileWriter("out.txt");
        fw.write(distance(a, b, x, y, z) + "");
        fw.flush();
    }

    public static int distance(String a, String b, int x, int y, int z) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < a.length() + 1; i++) {
            dp[i][0] = i * x;
        }
        for (int j = 0; j < b.length() + 1; j++) {
            dp[0][j] = j * y;
        }

        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + x, Math.min(dp[i][j - 1] + y, dp[i - 1][j - 1] + z));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
