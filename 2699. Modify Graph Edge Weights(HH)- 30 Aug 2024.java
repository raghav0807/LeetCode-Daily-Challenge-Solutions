import java.util.*;

class Solution {
    private static final int INF = Integer.MAX_VALUE/ 2;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        List<Integer> negativeEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if (w == -1) {
                negativeEdges.add(i);
            } else {
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }
        }

        int[] dist = dijkstra(graph, source, n);
        if (dist[destination] < target) {
            return new int[][]{};
        }

        for (int i : negativeEdges) {
            int u = edges[i][0], v = edges[i][1];
            graph.get(u).add(new int[]{v, 1});
            graph.get(v).add(new int[]{u, 1});
            edges[i][2] = 1;

            dist = dijkstra(graph, source, n);
            if (dist[destination] <= target) {
                int diff = target - dist[destination];
                edges[i][2] += diff;
                graph.get(u).get(graph.get(u).size() - 1)[1] += diff;
                graph.get(v).get(graph.get(v).size() - 1)[1] += diff;

                for (int j = i + 1; j < edges.length; j++) {
                    if (edges[j][2] == -1) {
                        edges[j][2] = INF;
                    }
                }
                return edges;
            }
        }
        int[] curDist = dijkstra(graph, source,n);
        if(curDist[destination] > target)  return new int[][]{}; 
        return edges;
    }

    private int[] dijkstra(List<List<int[]>> graph, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], distance = cur[1];

            if (distance > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return dist;
    }
}


