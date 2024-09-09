class Solution {
  public int[][] spiralMatrix(int m, int n, ListNode head) {
      int[][] matrix = new int[m][n];
      
      // Initialize all elements to -1
      for (int i = 0; i < m; i++) {
          Arrays.fill(matrix[i], -1);
      }
      
      int top = 0, bottom = m - 1, left = 0, right = n - 1;
      ListNode current = head;
      
      while (top <= bottom && left <= right) {
          for (int i = left; i <= right; i++) {
              if (current == null) return matrix;
              matrix[top][i] = current.val;
              current = current.next;
          }
          top++;
          
          for (int i = top; i <= bottom; i++) {
              if (current == null) return matrix;
              matrix[i][right] = current.val;
              current = current.next;
          }
          right--;
          
          
          if (top <= bottom) {
              for (int i = right; i >= left; i--) {
                  if (current == null) return matrix;
                  matrix[bottom][i] = current.val;
                  current = current.next;
              }
              bottom--;
          }
          
          if (left <= right) {
              for (int i = bottom; i >= top; i--) {
                  if (current == null) return matrix;
                  matrix[i][left] = current.val;
                  current = current.next;
              }
              left++;
          }
      }
      
      return matrix;
  }
}

