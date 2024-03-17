import java.io.*;
import java.util.StringTokenizer;

public class Huffman {
    private static final Long MAX = 1_000_000_000L * 1_000_000_000L;
    public static long doHuff(long[] a) {
        long[] b = new long[a.length + 2];
        int i = 0, j = 0;
        long res = 0;
        for (int k = 0; k < a.length; k++) {
            b[k] = MAX;
        }
        for (int k = 0; k < a.length - 3; k++) {
            if (a[i] + a[i + 1] <= a[i] + b[j] && a[i] + a[i + 1] <= b[j] + b[j + 1]) {
                b[k] = a[i] + a[i + 1];
                res += b[k];
                i += 2;
                continue;
            }
            if (a[i] + b[j] <= a[i] + a[i + 1] && a[i] + b[j] <= b[j] + b[j + 1]) {
                b[k] = a[i] + b[j];
                res += b[k];
                i++;
                j++;
                continue;
            }
            if (b[j] + b[j + 1] <= a[i] + a[i + 1] && b[j] + b[j + 1] <= a[i] + b[j]) {
                b[k] = b[j] + b[j + 1];
                res += b[k];
                j += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        long[] freq = new long[n + 2];
        for (int i = 0; i < n; i++) {
            freq[i] = scanner.nextInt();
        }
        freq[n] = MAX;
        freq[n + 1] = MAX;
        long i = doHuff(freq);
        FileWriter writer = new FileWriter("huffman.out");
        writer.write(i + "");
        writer.flush();
        writer.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("huffman.in"));
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