class Solution {
  private int m, n;
  private int[][] grid1, grid2;
  private boolean[][] visited;
  private int[] dx = {-1, 1, 0, 0};
  private int[] dy = {0, 0, -1, 1};

  public int countSubIslands(int[][] grid1, int[][] grid2) {
      this.grid1 = grid1;
      this.grid2 = grid2;
      m = grid1.length;
      n = grid1[0].length;
      visited = new boolean[m][n];
      int count = 0;

      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid2[i][j] == 1 && !visited[i][j] && dfs(i, j)) {
                  count++;
              }
          }
      }

      return count;
  }

  private boolean dfs(int i, int j) {
      if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || visited[i][j]) {
          return true;
      }

      visited[i][j] = true;
      boolean isSubIsland = grid1[i][j] == 1;

      for (int k = 0; k < 4; k++) {
          int newI = i + dx[k];
          int newJ = j + dy[k];
          isSubIsland &= dfs(newI, newJ);
      }

      return isSubIsland;
  }
}

