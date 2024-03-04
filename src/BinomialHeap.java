import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinomialHeap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        Long val = scanner.nextLong();
        String trim = Long.toBinaryString(val);
        StringBuilder builder = new StringBuilder();
        for (int i = trim.length() - 1; i >= 0; i--) {
            if (trim.charAt(i) == '1') {
                builder.append(trim.length() - 1 - i).append("\n");
            }
        }
        String trim1 = builder.toString().trim();
        FileWriter fw = new FileWriter("output.txt");
        fw.write(trim1);
        fw.flush();
        fw.close();
    }
}

