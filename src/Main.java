import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class Job {
    int arrivalTime;
    int executionTime;
    int pos;

    public Job(int arrivalTime, int executionTime, int pos) {
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.pos = pos;
    }
}

public class Main {
    static int minFee = Integer.MAX_VALUE;
    static Job[] bestOrder;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(scanner.nextInt(), scanner.nextInt(), i + 1);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.arrivalTime));

        dfs(jobs, new Job[jobs.length], new boolean[jobs.length], 0, 0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(minFee).append("\n");
        for (Job job : bestOrder) {
            sb.append(job.pos).append(" ");
        }
        PrintWriter pw = new PrintWriter("output.txt");
        pw.write(sb.toString().trim());
        pw.flush();
        pw.close();
    }

    static void dfs(Job[] jobs, Job[] order, boolean[] used, int idx, int currentTime, int totalFee) {
        if (totalFee >= minFee) return;

        if (idx == jobs.length) {
            minFee = totalFee;
            bestOrder = order.clone();
            return;
        }

        for (int i = 0; i < jobs.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            order[idx] = jobs[i];
            int startTime = Math.max(currentTime, jobs[i].arrivalTime);
            dfs(jobs, order, used, idx + 1, startTime + jobs[i].executionTime, totalFee + startTime - jobs[i].arrivalTime);
            used[i] = false;
        }
    }
}