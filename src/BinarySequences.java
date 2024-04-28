import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinarySequences {
    static FileWriter fw;

    static {
        try {
            fw = new FileWriter("output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static short[][] cells;
    static boolean[][] dir;

    public BinarySequences() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        cells = new short[a.length() + 1][b.length() + 1];
        dir = new boolean[a.length() + 1][b.length() + 1];
        a = trim(a);
        b = trim(b);
        solver(a, b);
        fw.flush();
    }

    public static void solver(String a, String b) throws IOException {
        for (int i = a.length() - 1; i > -1; i--) {
            for (int j = b.length() - 1; j > -1; j--) {
                if (a.charAt(i) == b.charAt(j)) {
                    cells[i][j] = (short) (cells[i + 1][j + 1] + 1);
                } else {
                    if (cells[i][j + 1] > cells[i + 1][j]) {
                        cells[i][j] = cells[i][j + 1];
                        dir[i][j] = true;
                    } else if (cells[i][j + 1] < cells[i + 1][j]) {
                        cells[i][j] = cells[i + 1][j];
                    } else {
                        boolean direction = getDirection(i, j, a, b);
                        cells[i][j] = direction ? cells[i][j + 1] : cells[i + 1][j];
                        dir[i][j] = direction;
                    }
                }
            }
        }

        getAnswer(a, b);
    }

    private static void getAnswer(String a, String b) throws IOException {
        int i = 0;
        int j = 0;
        fw.write(cells[i][j] + "\n");
        char ch;
        short val = cells[i][j];
        while (val != 0) {
            ch = a.charAt(i);
            fw.write(ch);
            i++;
            j++;
            while (i < a.length() && j < b.length() && a.charAt(i) != b.charAt(j)) {
                if (dir[i][j]) {
                    j++;
                } else {
                    i++;
                }
            }
            val = cells[i][j];
        }
    }

    private static boolean getDirection(int i, int j, String a, String b) {
        int ci = i + 1;
        int cj = j;
        int bi = i;
        int bj = j + 1;
        int alen = a.length();
        int blen = b.length();
        while (ci < alen && cj < blen && bi < alen && bj < blen && cells[ci][cj] > 0 && cells[bi][bj] > 0) {
            while (a.charAt(ci) != b.charAt(cj)) {
                if (cells[ci][cj + 1] > cells[ci + 1][cj]) {
                    cj++;
                    continue;
                }
                else if (cells[ci][cj + 1] < cells[ci + 1][cj]) {
                    ci++;
                    continue;
                }
                else if (dir[ci][cj]) {
                    cj++;
                    continue;
                }
                else {
                    ci++;
                    continue;
                }
            }
            while (a.charAt(bi) != b.charAt(bj)) {

                if (cells[bi][bj + 1] > cells[bi + 1][bj]) {
                    bj++;
                    continue;
                }
                else if (cells[bi][bj + 1] < cells[bi + 1][bj]) {
                    bi++;
                    continue;
                }
                else if (dir[bi][bj]) {
                    bj++;
                    continue;
                }
                else {
                    bi++;
                    continue;
                }
            }


            if (a.charAt(ci) > a.charAt(bi)) {
                return false;
            }
            else if (a.charAt(ci) < a.charAt(bi)) {
                return true;
            }

            if (ci == bi && cj == bj) {
                return false;
            }

            bi++; bj++; ci++; cj++;
        }
        return true;
    }

    public static String trim(String str) {
        int cnter = 0;
        while (cnter < str.length() && str.charAt(cnter) == '0') {
            cnter++;
        }
        return str.substring(cnter);
    }
}
