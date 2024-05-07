import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int components;

    public static void main(String[] args) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter("output.txt")) {

            FastReader scanner = new FastReader();

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            int[] parents = new int[n + 1];
            int[] sizes = new int[n + 1];
            int[] from = new int[m + 1];
            int[] to = new int[m + 1];
            boolean[] rem = new boolean[m + 1];
            int[] order = new int[q + 1];
            components = n;

            for (int i = 1; i <= n; i++) {
                sizes[i] = 1;
                parents[i] = i;
            }

            for (int i = 1; i <= m; i++) {
                from[i] = scanner.nextInt();
                to[i] = scanner.nextInt();
            }

            for (int i = 1; i <= q; i++) {
                int index = scanner.nextInt();
                rem[index] = true;
                order[i] = index;
            }


            for (int i = 1; i <= m; i++) {
                if (!rem[i]) {
                    union(from[i], to[i], sizes, parents);
                }
            }

            if (components == 1) {
                for (int i = 0; i < q; i++) {
                    writer.print("1");
                }
                return;
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = q; i >= 1; i--) {
                union(from[order[i]], to[order[i]], sizes, parents);
                if (components == 1) {
                    stringBuilder.append(0);
                    for (int j = i - 1; j >= 1 ; j--) {
                        stringBuilder.append(1);
                    }
                    break;
                }
                else {
                    stringBuilder.append(0);
                }
            }

            writer.print(stringBuilder.reverse());

        }

    }

    private static void union(int u, int v, int[] sizes, int[] parents) {
        int root1 = findRoot(u, parents);
        int root2 = findRoot(v, parents);
        if (root1 == root2) return;
        if (sizes[root1] < sizes[root2]) {
            int temp = root2;
            root2 = root1;
            root1 = temp;
        }
        parents[root2] = root1;
        sizes[root1] += sizes[root2];
        components--;
    }

    private static int findRoot(int x, int[] parents) {
        if (x == parents[x]) return x;
        return findRoot(parents[x], parents);
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("input.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}