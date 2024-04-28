import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Machines {
    static int[][] efficiencies;
    static int[][] edge;
    static int[] mt;
    static boolean[] visited;
    static boolean[] blockedEdges;
    static int[] from;
    static int[] path;
    static int size;
    static int res = 0;
    static int l = 1;
    static int r = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> back = new HashMap<>();
    static int[][] list = new int[size][];

    public static void main(String[] args) throws FileNotFoundException {
        long l1 = System.currentTimeMillis();
        FastReader fr = new FastReader();
        size = fr.nextInt();

        edge = new int[2 * size][2 * size];
        efficiencies = new int[size][size];
        visited = new boolean[2 * size];
        blockedEdges = new boolean[2 * size];
        mt = new int[size];
        from = new int[2 * size];
        path = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                efficiencies[i][j] = fr.nextInt();
            }
        }
        compress(efficiencies);
        r = map.size();
        binarySearch();
        if (canBuildMatching(r)) {
            res = r;
        } else {
            canBuildMatching(l);
            res = l;
        }
        long l3 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        builder.append(back.get(res)).append("\n");
        restorePath();
        for (int i = 0; i < size - 1; i++) {
            builder.append(path[i] + 1).append(" ");
        }
        builder.append(path[size - 1] + 1);
        PrintWriter pw = new PrintWriter("output.out");
        pw.write(builder.toString());
        long l2 = System.currentTimeMillis();
        System.out.println(l3 - l1);
        System.out.println(l2 - l3);
        pw.flush();
        pw.close();
    }

    public static void compress(int[][] arr) {
        List<Integer> flattenedList = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .boxed().sorted().toList();

        for (Integer integer : flattenedList) {
            map.computeIfAbsent(integer, k -> map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                back.put(map.get(arr[i][j]), arr[i][j]);
                arr[i][j] = map.get(arr[i][j]);
            }
        }
    }

    public static void binarySearch() {
        while (l < r - 1) {
            int mid = (l + r) >>> 1;
            if (canBuildMatching(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }

    public static boolean canBuildMatching(int m) {
        list = new int[size][];

        for (int i = 0; i < size; i++) {
            int cnt = 0;
            for (int j = 0; j < size; j++) {
                if (efficiencies[i][j] >= m) {
                    cnt++;
                }
            }
            list[i] = new int[cnt];
            int pos = 0;
            for (int j = 0; j < size; j++) {
                if (efficiencies[i][j] >= m) {
                    list[i][pos++] = j;
                }
            }
        }

        Arrays.fill(mt, -1);
        boolean[] used1 = new boolean[size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < list[i].length; ++j) {
                if (mt[list[i][j]] == -1) {
                    mt[list[i][j]] = i;
                    used1[i] = true;
                    break;
                }
            }
        }

        for (int v = 0; v < size; ++v) {
            if (used1[v]) {
                continue;
            }
            visited = new boolean[2 * size];
            kuhnAvailable(v);
        }

        for (int i = 0; i < size; ++i) {
            if (mt[i] == -1) {
                return false;
            }
        }

        return true;
    }

    public static boolean kuhnAvailable(int v) {
        if (!visited[v]) {
            visited[v] = true;
            for (int i = 0; i < list[v].length; i++) {
                int to = list[v][i];
                if (mt[to] == -1 || kuhnAvailable(mt[to])) {
                    mt[to] = v;
                    return true;
                }
            }
        }
        return false;
    }

    public static void dfs(int v, int p) {
        if (!visited[v]) {
            visited[v] = true;
            from[v] = p;
            for (int i = 0; i < 2 * size; i++) {
                if (edge[v][i] == 1 && !blockedEdges[i]) {
                    dfs(i, v);
                }
            }
        }
    }

    public static void findPath(int v) {
        for (int i = 0; i < size; i++) {
            edge[i][path[i] + size] = 1;
        }

        visited = new boolean[2 * size];

        for (int i = 0; i < size; i++) {
            from[i] = -1;
        }
        dfs(v, v);
        for (int i = 0; i < size; i++) {
            edge[i][path[i] + size] = 0;
        }
        for (int i = size; i < 2 * size; i++) {
            if (visited[i] && !blockedEdges[i] && efficiencies[v][i - size] >= res) {
                blockedEdges[i] = true;
                path[v] = i - size;
                int u = from[i];
                while (u != from[u]) {
                    path[u] = from[u] - size;
                    u = from[from[u]];
                }
                break;
            }
        }
        blockedEdges[v] = true;
    }

    public static void restorePath(){
        for (int i = 0; i < size; i++) {
            path[mt[i]] = i;
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (efficiencies[i][j] >= res) {
                    edge[size + j][i] = 1;
                }
            }
        }
        for (int i = 0; i < size; i++){
            findPath(i);
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("input.in"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}