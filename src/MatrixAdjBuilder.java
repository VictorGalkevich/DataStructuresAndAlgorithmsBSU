import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class MatrixAdjBuilder {
    public static void main(String[] args) throws IOException {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int[][] am = new int[n][n];
        int m = fastReader.nextInt();
        for (int i = 0; i < m; i++) {
            int k = fastReader.nextInt();
            int j = fastReader.nextInt();
            am[k - 1][j - 1] = 1;
            am[j - 1][k - 1] = 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                str.append(am[i][j]).append(" ");
            }
            builder.append(str.toString().trim()).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(builder.toString());
        writer.close();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
