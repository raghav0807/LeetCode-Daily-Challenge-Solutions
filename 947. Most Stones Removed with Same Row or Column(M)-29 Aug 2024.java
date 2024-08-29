class Solution {
  class UnionFind {
      private int[] parent;
      private int count;

      public UnionFind(int n) {
          parent = new int[n];
          for (int i = 0; i < n; i++) {
              parent[i] = i;
          }
          count = n;
      }

      public int find(int x) {
          if (parent[x] != x) {
              parent[x] = find(parent[x]);
          }
          return parent[x];
      }

      public void union(int x, int y) {
          int rootX = find(x);
          int rootY = find(y);
          if (rootX != rootY) {
              parent[rootX] = rootY;
              count--;
          }
      }

      public int getCount() {
          return count;
      }
  }

  public int removeStones(int[][] stones) {
      int n = stones.length;
      UnionFind uf = new UnionFind(n);

      for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
              if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                  uf.union(i, j);
              }
          }
      }

      return n - uf.getCount();
  }
}

