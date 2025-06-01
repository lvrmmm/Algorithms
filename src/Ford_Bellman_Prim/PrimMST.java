package Ford_Bellman_Prim;

import java.util.*;
import java.io.*;

public class PrimMST {
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int key;
        int parent;
        public Pair(int vertex, int key, int parent) {
            this.vertex = vertex;
            this.key = key;
            this.parent = parent;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.key, other.key);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] uvw = reader.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }


        int[] key = new int[n+1];
        int[] parent = new int[n+1];
        boolean[] inMST = new boolean[n+1];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        key[1] = 0;
        pq.offer(new Pair(1, 0, -1));

        int totalWeight = 0;
        int mstSize = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            if (inMST[u]) continue;

            inMST[u] = true;
            totalWeight += current.key;
            mstSize++;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.offer(new Pair(v, key[v], u));
                }
            }
        }

        if (mstSize != n) {
            System.out.println(-1);
            return;
        }

        List<String> edges = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int u = Math.min(i, parent[i]);
            int v = Math.max(i, parent[i]);
            edges.add(u + " " + v);
        }
        Collections.sort(edges);

        System.out.println(totalWeight);
        StringBuilder sb = new StringBuilder();
        for (String edge : edges) {
            sb.append(edge).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}