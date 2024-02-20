import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] initial = new int[n];
        for (int i = 0; i < n; i++) {
            initial[i] = scanner.nextInt();
        }
        if (n == 2) {
            System.out.println(-1);
            return;
        }
        if (n == 1) {
            System.out.println(initial[0]);
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 3];
        int[] route = new int[n + 3];
        initial[1] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[1 + i] > dp[i]) {
                route[i + 3] = i + 1;
                dp[3 + i] = initial[i] + dp[i + 1];
            } else {
                route[i + 3] = i;
                dp[3 + i] = initial[i] + dp[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(n);
        int next = route[n + 2];
        while (!(next < 3)) {
            list.add(next - 2);
            next = route[next];
        }
        if (next == 2) {
            list.add(1);
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            Collections.swap(list, l, r);
            l++;
            r--;
        }
        System.out.println(dp[n + 2]);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(" ");
        }
        System.out.println(builder.toString().trim());
    }
}