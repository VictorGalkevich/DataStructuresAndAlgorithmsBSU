import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BFS {
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
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                labels[i] = smallest++;

                while (!q.isEmpty()) {
                    Integer current = q.poll();

                    for (int j = 0; j < size; j++) {
                        if (adjM[current][j] == 1 && !visited[j]) {
                            q.offer(j);
                            visited[j] = true;
                            labels[j] = smallest++;
                        }
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < size; i++) {
            pw.append(String.valueOf(labels[i])).append(" ");
        }
        pw.flush();
        pw.close();
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