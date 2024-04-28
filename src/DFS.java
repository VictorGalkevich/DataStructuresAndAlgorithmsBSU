import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS {
    public static int[][] adjM;
    public static int[] labels;
    public static boolean[] visited;
    public static int size;
    public static int smallest = 1;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader fr = new FastReader();
        size = fr.nextInt();
        labels = new int[size];
        visited = new boolean[size];
        adjM = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjM[i][j] = fr.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < size; i++) {
            pw.append(String.valueOf(labels[i])).append(" ");
        }
        pw.flush();
        pw.close();
    }

    public static void dfs(int vertex) {
        visited[vertex] = true;
        labels[vertex] = smallest++;
        for (int i = 0; i < size; i++) {
            if (adjM[vertex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
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