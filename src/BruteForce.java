import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BruteForce {
    static int[] from;
    static int[] tr;
    static int[] p;
    static long record = 0;
    static long curr = 0;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        from = new int[n];
        tr = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            from[i] = fr.nextInt();
            tr[i] = fr.nextInt();
            p[i] = i + 1;
        }

        for (int i = 0; i < n; ++i) {
            curr = curr > from[i] ? curr : from[i];
            long prev = record;
            record += curr - from[i];
            if (record < prev) {
                record = prev;
            }
            curr += tr[i];
        }

        long min = record;
        List<int[]> jobs = new ArrayList<>();
        int[] job = new int[n];
        for (int i = 0; i < n; i++) {
            job[i] = i + 1;
        }
        jobs.add(job);
        while (hasMore()) {
            curr = 0;
            record = 0;
            for (int i = 0; i < n; ++i) {
                curr = curr > from[p[i] - 1] ? curr : from[p[i] - 1];
                long prev = record;
                record += - from[p[i] - 1] + curr;
                if (record < prev) {
                    record  = prev;
                }
                curr += tr[p[i] - 1];
            }
            if (record < min) {
                min = record;
                jobs = new ArrayList<>();
                int[] t = new int[n];
                System.arraycopy(p, 0, t, 0, n);
                jobs.add(t);
            }
            else if (record == min) {
                int[] t = new int[n];
                System.arraycopy(p, 0, t, 0, n);
                jobs.add(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n");
        for (int[] ints : jobs) {
            for (int j = 0; j < ints.length - 1; ++j) {
                sb.append(ints[j]).append(" ");
            }
            sb.append(ints[ints.length - 1]).append("\n");
        }
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(sb.toString());
        pw.flush();
        pw.close();
    }

    static boolean hasMore() {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
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
