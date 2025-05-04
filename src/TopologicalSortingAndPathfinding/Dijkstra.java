package TopologicalSortingAndPathfinding;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }

    static class Node implements Comparable<Node> {
        int vertex, dist;
        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    static List<Integer> dijkstra(int n, int start, int end, List<List<Edge>> adj, int[] dist) {
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : adj.get(u)) {
                int v = edge.to, w = edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new Node(v, dist[v]));
                } else if (dist[u] + w == dist[v]) {
                    if (parent[v] == -1 || u < parent[v]) {
                        parent[v] = u;
                    }
                }
            }
        }

        if (dist[end] == Integer.MAX_VALUE) return null;

        // Восстановление пути
        LinkedList<Integer> path = new LinkedList<>();
        for (int v = end; v != -1; v = parent[v]) path.addFirst(v);
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        sc.nextLine();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            for (int j = 1; j < parts.length; j += 2) {
                int v = Integer.parseInt(parts[j]);
                int w = Integer.parseInt(parts[j + 1]);
                adj.get(i).add(new Edge(v, w));
            }
        }

        int[] dist = new int[n + 1];
        List<Integer> path = dijkstra(n, a, b, adj, dist);

        if (path == null) {
            System.out.println("-1");
        } else {
            System.out.println(dist[b]);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" ");
            }
        }
    }
}