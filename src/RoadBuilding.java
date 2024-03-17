import java.io.*;
import java.util.StringTokenizer;

public class RoadBuilding {
    public static int cnt;
    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        cnt = n;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            union(parent, size, from, to);
            builder.append(cnt).append("\n");
        }
        FileWriter writer = new FileWriter("output.txt");
        writer.write(builder.toString().trim());
        writer.flush();
        writer.close();
    }

    public static void union(int[] parent, int[] size, int x, int y) {
        x = findSet(parent, x);
        y = findSet(parent, y);
        if (x != y) {
            if (size[x] < size[y]) {
                int t = x;
                x = y;
                y = t;
            }
        } else {
            return;
        }
        parent[y] = x;
        size[x] += size[y];
        cnt--;
    }

    public static int findSet(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findSet(parent, parent[x]);
        return parent[x];
    }



    static class FastReader {
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
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
