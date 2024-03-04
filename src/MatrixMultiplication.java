import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int quantity = scanner.nextInt();
        int[] dim = new int[quantity + 1];
        dim[0] = scanner.nextInt();
        dim[1] = scanner.nextInt();
        for (int i = 1; i < quantity; i++) {
            scanner.nextInt();
            dim[i + 1] = scanner.nextInt();
        }
        int res = matrix(dim);

        FileWriter writer = new FileWriter("output.txt");
        writer.write(res + "");
        writer.flush();

    }

    public static int matrix(int[] dim) {
        int n = dim.length;
        int[][] dp = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dim[i - 1] * dim[k] * dim[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

}
