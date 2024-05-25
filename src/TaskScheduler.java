import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();

        int n = scanner.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            long si = scanner.nextLong();
            long pi = scanner.nextLong();
            tasks[i] = new Task(si, pi, i + 1);
        }

        Arrays.sort(tasks, Comparator.comparingLong(task -> task.si));

        long[] processorEndTime = new long[2];
        List<Integer> order = new ArrayList<>();

        for (Task task : tasks) {
            int processor;
            if (processorEndTime[0] <= processorEndTime[1]) {
                processor = 0;
            } else {
                processor = 1;
            }

            long loadTime = processorEndTime[processor] + task.si;
            processorEndTime[processor] = loadTime + task.pi;

            if (loadTime > processorEndTime[processor == 0 ? 1 : 0]) {
                processorEndTime[processor == 0 ? 1 : 0] = loadTime;
            }
            order.add(task.index);
        }

        long completionTime = Math.max(processorEndTime[0], processorEndTime[1]);

        PrintWriter pw = new PrintWriter("output.txt");

        pw.write(completionTime + "\n");
        for (int taskIndex : order) {
            pw.write(taskIndex + " ");
        }
        pw.flush();
        pw.close();
    }

    static class Task {
        long si;
        long pi;
        int index;

        Task(long si, long pi, int index) {
            this.si = si;
            this.pi = pi;
            this.index = index;
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}