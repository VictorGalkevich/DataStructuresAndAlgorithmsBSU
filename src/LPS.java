import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LPS {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String init = scanner.next();
        FileWriter fw = new FileWriter("output.txt");
        String lps = lps(init);
        fw.write(lps.length() + "\n");
        fw.write(lps);
        fw.flush();
    }

    public static String lps(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                res.append(s.charAt(i));
                i++;
                j--;
            } else if (dp[i][j] == dp[i + 1][j])  {
                i++;
            } else {
                j--;
            }
        }
        String rrr = "";
        if (dp[0][s.length() - 1] % 2 == 0) {
            rrr += res;
            rrr += res.reverse();
        } else {
            rrr += res;
            res.deleteCharAt(res.length() - 1);
            rrr += res.reverse();
        }
        return rrr;
    }
}