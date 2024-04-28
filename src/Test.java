import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("output.out");
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 499; j++) {
                pw.append(String.valueOf(rand.nextInt(1000000000) + 1)).append(" ");
            }
            pw.append(String.valueOf(rand.nextInt(4) + 1)).append(" ");
            pw.append("\n");
        }
        pw.flush();
        pw.close();
    }
}

