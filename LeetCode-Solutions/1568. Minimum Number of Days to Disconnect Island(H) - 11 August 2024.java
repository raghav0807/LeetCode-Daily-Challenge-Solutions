class Solution {
  private int m, n;
  private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int minDays(int[][] grid) {
      m = grid.length;
      n = grid[0].length;

      if (countIslands(grid) != 1) return 0;

      if (countLandCells(grid) == 1) return 1;

      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1) {
                  grid[i][j] = 0;
                  if (countIslands(grid) != 1) return 1;
                  grid[i][j] = 1;
              }
          }
      }

      return 2;
  }

  private int countIslands(int[][] grid) {
      int count = 0;
      boolean[][] visited = new boolean[m][n];
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1 && !visited[i][j]) {
                  dfs(grid, i, j, visited);
                  count++;
              }
          }
      }
      return count;
  }

  private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
      if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) return;
      visited[i][j] = true;
      for (int[] dir : directions) {
          dfs(grid, i + dir[0], j + dir[1], visited);
      }
  }

  private int countLandCells(int[][] grid) {
      int count = 0;
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 1) count++;
          }
      }
      return count;
  }
}

