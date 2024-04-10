import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KmpSearch {
    public static void main(String[] args) throws FileNotFoundException {
        String str;
        String obr;
        int xoxo;
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            xoxo = scanner.nextInt();
            str = scanner.next();
            obr = scanner.next();
        }
        char[] base = (obr + "@" + str + str).toCharArray();
        int[] pi = prefixFunction(base);
        int shift = -1;
        for (int i = 0; i < pi.length; i++) {
            if (pi[i] == str.length()) {
                shift = i - 2 * str.length();
                break;
            }
        }
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(shift + "");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int[] prefixFunction(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i) {
            int j = pi[i - 1];
            while ((j > 0) && (s[i] != s[j])) {
                j = pi[j - 1];
            }
            if (s[i] == s[j]) {
                ++j;
            }
            pi[i] = j;
        }
        return pi;
    }
}