import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LISWithTree {
    private static int max;
    private static int[] arr;
    public static int lis(int[] a) {
        SegmentTree segmentTree = new SegmentTree();
        int[] dp = new int[a.length];
        dp[0] = 1;
        int shift = segmentTree.tree.length / 2;
        for (int i = 1; i < a.length; i++) {
            dp[i] = segmentTree.max(0, 0, shift, 0, arr[i]) + 1;
            segmentTree.replace(shift + arr[i], dp[i]);
        }
        return segmentTree.result();
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
        max = map.size();
    }

    public static class SegmentTree {
        public int[] tree;

        public SegmentTree() {
            int halfSize = 1;
            while(halfSize < max) {
                halfSize = halfSize << 1;
            }
            int[] tree = new int[2 * halfSize];
            for (int i = 0; i < 2 * halfSize; i++) {
                tree[i] = 1;
            }
            this.tree = tree;
        }

        public void replace(int i, int x) {
            int pos = i;
            tree[pos] = x;
            while (pos != 0) {
                int parent = (pos - 1) / 2;
                tree[parent] = Math.max(tree[2 * parent + 1], tree[2 * parent + 2]);
                pos = parent;
            }
        }

        public int max(int node, int tl, int tr, int l, int r) {
            if (l >= tr || r <= tl) {
                return Integer.MIN_VALUE;
            }

            if (l <= tl && tr <= r) {
                return tree[node];
            }

            int mid = (tl + tr) / 2;
            int lc = 2 * node + 1;
            int rc = 2 * node + 2;

            int lmax = max(lc, tl, mid, l, r);
            int rmax = max(rc, mid, tr, l, r);

            return Math.max(lmax, rmax);
        }

        public int result() {
            return tree[0];
        }
    }
}
