import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[m];
        Map<Integer, Boolean> map = new HashMap<>();
        Arrays.fill(arr, -1);
        for (int i = 0; i < q; i++) {
            int val = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                int pos = hash(val, j, c, m);
                if (map.get(val) != null) {
                    break;
                } else if (arr[pos] == -1) {
                    arr[pos] = val;
                    map.put(val, true);
                    break;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i < m; i++) {
            bw.append(String.valueOf(arr[i])).append(" ");
        }
        bw.flush();
        bw.close();
    }

    public static int hash(int x, int i, int c,  int m) {
        return ((x % m) + c * i) % m;
    }
}
