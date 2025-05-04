package TopologicalSortingAndPathfinding;

import java.util.*;

public class BFSShortestPath {
    public static List<Integer> bfsShortestPath(int n, int start, int end, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                    if (v == end) break;
                }
            }
        }

        if (!visited[end]) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = end; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                String[] parts = line.trim().split("\\s+");
                for (String s : parts) {
                    int v = Integer.parseInt(s);
                    adj.get(i).add(v);
                }
            }
        }
        List<Integer> path = bfsShortestPath(n, a, b, adj);
        if (path == null) {
            System.out.println("-1");
        } else {
            System.out.println(path.size() - 1);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
