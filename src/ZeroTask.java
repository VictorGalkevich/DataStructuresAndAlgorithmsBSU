import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroTask {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        Map<Integer, Boolean> map = new HashMap<>();
        long sum = 0;
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();
            if (map.get(k) == null) {
                map.put(k, true);
                sum += k;
            }
        }
        FileWriter writer = new FileWriter("output.txt");
        writer.write(sum + "");
        writer.flush();
    }
}