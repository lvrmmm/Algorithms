package Ford_Bellman_Prim;

import java.util.*;
import java.io.*;

public class FordBellman {
    static final long INF = Long.MAX_VALUE / 2;

    static class Edge {
        int from, to;
        long weight;

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int a = Integer.parseInt(firstLine[2]) - 1;
        int b = Integer.parseInt(firstLine[3]) - 1;

        List<Edge> edges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]) - 1;
            int v = Integer.parseInt(parts[1]) - 1;
            long w = Long.parseLong(parts[2]);
            edges.add(new Edge(u, v, w));
            edges.add(new Edge(v, u, w));
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        long[] dist = new long[n];
        int[] parent = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[a] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] < INF && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                    parent[e.to] = e.from;
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (Edge e : edges) {
            if (dist[e.from] < INF && dist[e.from] + e.weight < dist[e.to]) {
                if (isReachable(a, e.from, adj) && isReachable(e.from, b, adj)) {
                    hasNegativeCycle = true;
                    break;
                }
            }
        }

        if (hasNegativeCycle) {
            System.out.println(-1);
            return;
        }

        if (dist[b] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dist[b]);
            if (a == b) {
                System.out.println(a + 1);
            } else {
                List<Integer> path = new ArrayList<>();
                for (int v = b; v != -1; v = parent[v]) {
                    path.add(v + 1);
                }
                Collections.reverse(path);
                for (int i = 0; i < path.size(); i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(path.get(i));
                }
                System.out.println();
            }
        }
    }

    static boolean isReachable(int start, int end, List<List<Integer>> adj) {
        if (start == end) return true;
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (v == end) return true;
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return false;
    }
}