class Solution {
  public int numMagicSquaresInside(int[][] grid) {
      int rows = grid.length;
      int cols = grid[0].length;
      int count = 0;
      
      for (int i = 0; i <= rows - 3; i++) {
          for (int j = 0; j <= cols - 3; j++) {
              if (isMagicSquare(grid, i, j)) {
                  count++;
              }
          }
      }
      
      return count;
  }
  
  private boolean isMagicSquare(int[][] grid, int row, int col) {
      boolean[] used = new boolean[10];
      for (int i = row; i < row + 3; i++) {
          for (int j = col; j < col + 3; j++) {
              int num = grid[i][j];
              if (num < 1 || num > 9 || used[num]) {
                  return false;
              }
              used[num] = true;
          }
      }
      
      int sum = grid[row][col] + grid[row][col+1] + grid[row][col+2];
      
      for (int i = 0; i < 3; i++) {
          if (grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2] != sum) return false;
          if (grid[row][col+i] + grid[row+1][col+i] + grid[row+2][col+i] != sum) return false;
      }
      
      if (grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] != sum) return false;
      if (grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col] != sum) return false;
      
      return true;
  }
}

