import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cilinder {
    static boolean[][] visited;
    static int[][] matrix;
    static int n;
    static int m;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        m = fr.nextInt();
        matrix = new int[n][m];
        visited = new boolean[n][m];
        int cnter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = fr.nextInt();
                if (matrix[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    bfs(i, j);
                    cnter++;
                }
            }
        }
        PrintWriter pw = new PrintWriter("out.txt");
        pw.println(cnter);
        pw.flush();
        pw.close();
    }

    public static void bfs(int i, int j) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (Pair neighbour : getNeighbours(curr.x, curr.y)) {
                if (!visited[neighbour.x][neighbour.y]) {
                    visited[neighbour.x][neighbour.y] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    public static List<Pair> getNeighbours(int x, int y) {
        List<Pair> res = new ArrayList<>();
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx * dy != 0 || (dx == 0 && dy == 0)) {
                    continue;
                }
                if (-1 > x + dx || x + dx > n || 0 > y + dy || y + dy >= m) {
                    continue;
                }
                if (x + dx == -1) {
                    x = n - 1 - dx;
                } else if (x + dx == n) {
                    x = -dx;
                }
                if (matrix[x + dx][y + dy] == 0) {
                    res.add(new Pair(x + dx, y + dy));
                }
            }
        }

        return res;
    };

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("in.txt"));
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
