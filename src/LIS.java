import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.*;

public class LIS {
    public static int lis(int[] a) {
        List<Integer> res = new ArrayList<>();
        res.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] > res.get(res.size() - 1)) {
                res.add(a[i]);
            } else {
                int low = binarySearch(res, a[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                res.set(low, a[i]);
            }
        }
        return res.size();
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("in.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        FileWriter fw = new FileWriter("output.txt");
        fw.write(lis(arr) + "");
        fw.flush();
    }
}
