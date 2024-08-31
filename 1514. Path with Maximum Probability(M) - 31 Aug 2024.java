import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }
        
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start, 1.0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;
            
            if (node == end) return prob;
            
            if (prob < maxProb[node]) continue;
            
            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = prob * neighbor.prob;
                
                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.offer(new Pair(nextNode, nextProb));
                }
            }
        }
        
        return 0.0;
    }
    
    private class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
