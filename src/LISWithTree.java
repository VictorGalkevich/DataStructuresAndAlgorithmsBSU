import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LISWithTree {
    private static int[] arr;
    public static long lis(int[] a) {
        LazyTreeNode segmentTree = new LazyTreeNode(0, arr.length);
        long[] dp = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            if (arr[i] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = segmentTree.max(0, arr[i]) + 1;
            }
            segmentTree.replace(arr[i], dp[i]);
        }
        return segmentTree.max(0, arr.length);
    }
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            int n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
        }
        compress(arr);
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(lis(arr) + "");
            fw.flush();
        }
    }

    public static void compress(int[] arr) {
        int[] b = Arrays.copyOf(arr, arr.length);
        Arrays.sort(b);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(b[i], k -> map.size());
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
    }

    public static class LazyTreeNode {
        int lb;
        int rb;
        long val;
        LazyTreeNode left;
        LazyTreeNode right;

        LazyTreeNode(int lb, int rb) {
            this.lb = lb;
            this.rb = rb;
            if (lb + 1 == rb) {
                this.val = 0;
            } else {
                int mid = (lb + rb) / 2;
                this.left = new LazyTreeNode(lb, mid);
                this.right = new LazyTreeNode(mid, rb);
                this.val = Math.max(left.val, right.val);
            }
        }

        void replace(int pos, long x) {
            this.val = x;
            if (left != null) {
                if (pos < left.rb) {
                    left.replace(pos, x);
                    this.val = Math.max(left.val, right.val);
                } else {
                    right.replace(pos, x);
                    this.val = Math.max(left.val, right.val);
                }
            }
        }

        long max(int lq, int rq) {
            if (lq <= lb && rb <= rq) {
                return this.val;
            } else if (Math.max(lq, lb) >= Math.min(rb, rq)) {
                return Long.MIN_VALUE;
            }

            return Math.max(left.max(lq, rq), right.max(lq, rq));
        }
    }
}
