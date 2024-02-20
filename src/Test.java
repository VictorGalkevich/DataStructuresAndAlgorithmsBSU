import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        while (true) {
            Random rnd = new Random();
            int n = new Random().nextInt(1000) + 1;
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = rnd.nextInt(10);
                b[i] = rnd.nextInt(10);
            }
            System.out.println("n: " + n);
            System.out.println("ARR1: ");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            System.out.println("ARR2: ");
            for (int i = 0; i < n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
            String victor = solverVictor(a, b);
            String toxa = solverVictor(a, b);
            if (!victor.equals(toxa)) {
                System.out.println("ERROR:");
                System.out.println("VICTOR: " + victor);
                System.out.println("TOXA: " + toxa);
            } else {
                System.out.println("SUCCESS:");
                System.out.println("VICTOR: " + victor);
                System.out.println("TOXA: " + toxa);
            }
        }
    }

    public static String solverVictor(int[] a, int[] b) {
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
        int len = dp[a.length - 1][b.length - 1];
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
        return len + "\n" + builder;
    }

    public static String solverAnton(int[] A, int[] B) {
        int n = A.length;
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
        }
        int i = n;
        int j = n;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while (matrix[i][j] > 0) {
            while (matrix[i][j - 1] == matrix[i][j]) {
                j--;
            }
            while (matrix[i - 1][j] == matrix[i][j]) {
                i--;
            }
            list.add(i - 1);
            list1.add(j - 1);
            i--;
            j--;
        }
        stringBuilder.append(matrix[n][n]).append("\n");
        for (int k = matrix[n][n] - 1; k >= 0; k--) {
            stringBuilder1.append(list1.get(k)).append(" ");
            stringBuilder.append(list.get(k)).append(" ");
        }
        stringBuilder.append("\n").append(stringBuilder1);
        return stringBuilder.toString();
    }
}

