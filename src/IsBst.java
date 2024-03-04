import java.io.*;
import java.util.StringTokenizer;

public class IsBst {

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        Cell[] arr = new Cell[n + 1];
        FileWriter fileWriter = new FileWriter("bst.out");
        arr[1] = new Cell(scanner.nextInt(), Long.MIN_VALUE, Long.MAX_VALUE);
        for (int i = 2; i <= n; i++) {
            int value = scanner.nextInt();
            int node = scanner.nextInt();
            String side = scanner.next();
            if (side.equals("L")){
                if (value >= arr[node].val || value < arr[node].left){
                    fileWriter.append("NO");
                    fileWriter.close();
                    return;
                }
                arr[i] = new Cell(value, arr[node].left, arr[node].val);
            } else {
                if (value < arr[node].val || value >= arr[node].right){
                    fileWriter.append("NO");
                    fileWriter.close();
                    return;
                }
                arr[i] = new Cell(value, arr[node].val, arr[node].right);
            }
        }
        fileWriter.append("YES");
        fileWriter.close();
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("bst.in"));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    public static class Cell {
        long val;
        long left;
        long right;

        public Cell(long val, long left, long right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
