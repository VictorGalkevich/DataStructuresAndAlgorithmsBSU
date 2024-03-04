import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IsHeap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        arr[0] = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int next = scanner.nextInt();
            if (next < arr[(i-1)/2]) {
                writer.write("No");
                writer.flush();
                writer.close();
                System.exit(0);
            }
            arr[i] = next;
        }
        writer.write("Yes");
        writer.flush();
        writer.close();
    }
}