import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 3000; i++) {
            builder.append(rand.nextInt(2));
        }
        PrintWriter fw = new PrintWriter("output.txt");
        fw.println(builder.toString());
        fw.flush();
    }
}