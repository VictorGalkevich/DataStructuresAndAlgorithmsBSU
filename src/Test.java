import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("output.out");
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                pw.append(String.valueOf(rand.nextInt(2))).append(" ");
            }
            pw.append("\n");
        }
        pw.flush();
        pw.close();
    }
}

