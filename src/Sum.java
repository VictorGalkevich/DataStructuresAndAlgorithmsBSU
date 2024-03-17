import java.io.*;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        int next = scanner.nextInt();
        long[] arr = new long[next];
        for (int i = 0; i < next; i++) {
            arr[i] = scanner.nextInt();
        }
        LazyTreeNode lt = new LazyTreeNode(0, next, arr);
        long q = scanner.nextLong();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String text = scanner.next();
            if (text.charAt(0) == 'F') {
                res.append(lt.sumOnSegment(scanner.nextInt(), scanner.nextInt())).append("\n");
            } else {
                int pos = scanner.nextInt();
                lt.addForElement(pos, scanner.nextLong());
            }
        }
        System.out.println(res.toString().trim());
    }
    public static class LazyTreeNode {
        int lb;
        int rb;
        long sum;
        long[] arr;
        LazyTreeNode left;
        LazyTreeNode right;

        LazyTreeNode(int lb, int rb, long[] arr) {
            this.lb = lb;
            this.rb = rb;
            this.arr = arr;
            if (lb + 1 == rb) {
                this.sum = arr[lb];
            } else {
                int mid = (lb + rb) / 2;
                this.left = new LazyTreeNode(lb, mid, arr);
                this.right = new LazyTreeNode(mid, rb, arr);
                this.sum = left.sum + right.sum;
            }
        }

        void addForElement(int pos, long x) {
            this.sum += x;
            if (left != null) {
                if (pos < left.rb) {
                    left.addForElement(pos, x);
                } else {
                    right.addForElement(pos, x);
                }
            }
        }

        long sumOnSegment(int lq, int rq) {
            if (lq <= lb && rb <= rq) {
                return this.sum;
            } else if (Math.max(lq, lb) >= Math.min(rb, rq)) {
                return 0;
            }

            return left.sumOnSegment(lq, rq) + right.sumOnSegment(lq, rq);
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
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
        long nextLong() { return Long.parseLong(next()); }
    }
}
