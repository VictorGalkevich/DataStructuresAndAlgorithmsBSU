import java.util.*;

public class HopcroftKarpAlgorithm {
    private static final int NIL = 0;

    private int[] pairU;
    private int[] pairV;
    private int[] dist;
    private int[][] edges;
    private int m;
    private int n;

    public int hopcroftKarp() {
        pairU = new int[m];
        pairV = new int[n];
        dist = new int[m];
        Arrays.fill(pairU, NIL);
        Arrays.fill(pairV, NIL);

        int matching = 0;
        while (bfs()) {
            for (int u = 0; u < m; u++) {
                if (pairU[u] == NIL && dfs(u)) {
                    matching++;
                }
            }
        }

        return matching;
    }

    private boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int u = 0; u < m; u++) {
            if (pairU[u] == NIL) {
                dist[u] = 0;
                queue.add(u);
            } else {
                dist[u] = Integer.MAX_VALUE;
            }
        }
        dist[NIL] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (dist[u] < dist[NIL]) {
                for (int v = 0; v < n; v++) {
                    if (edges[u][v] != 0 && dist[pairV[v]] == Integer.MAX_VALUE) {
                        dist[pairV[v]] = dist[u] + 1;
                        queue.add(pairV[v]);
                    }
                }
            }
        }

        return dist[NIL] != Integer.MAX_VALUE;
    }

    private boolean dfs(int u) {
        if (u == NIL) {
            return true;
        }

        for (int v = 0; v < n; v++) {
            if (edges[u][v] != 0 && dist[pairV[v]] == dist[u] + 1 && dfs(pairV[v])) {
                pairU[u] = v;
                pairV[v] = u;
                return true;
            }
        }

        dist[u] = Integer.MAX_VALUE;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {100, 123, 12, 12312},
                {123, 123, 123, 100},
                {0, 100, 0, 0},
                {0, 0, 100, 0}
        };
        int m = edges.length;
        int n = edges[0].length;

        HopcroftKarpAlgorithm algorithm = new HopcroftKarpAlgorithm();
        algorithm.edges = edges;
        algorithm.m = m;
        algorithm.n = n;

        int matching = algorithm.hopcroftKarp();
        System.out.println("Max matching: " + matching);
    }
}