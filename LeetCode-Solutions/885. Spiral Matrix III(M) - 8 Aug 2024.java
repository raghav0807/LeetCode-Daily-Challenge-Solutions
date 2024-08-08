class Solution {
  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
      int[] dr = {0, 1, 0, -1};
      int[] dc = {1, 0, -1, 0};
      
      int[][] result = new int[rows * cols][2];
      int index = 0;
      
      int len = 0;  
      int d = 0;    
      
      result[index++] = new int[]{rStart, cStart}; 
      
      while (index < rows * cols) {
          if (d == 0 || d == 2) len++;
          
          for (int i = 0; i < len; i++) {
              rStart += dr[d];
              cStart += dc[d];
              
              if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                  result[index++] = new int[]{rStart, cStart};
              }
          }
          
          d = (d + 1) % 4;  
      }
      
      return result;
  }
}

