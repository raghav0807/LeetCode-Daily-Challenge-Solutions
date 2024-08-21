class Solution {
  public int strangePrinter(String s) {
      int n = s.length();
      int[][] dp = new int[n][n];
      
      for (int len = 1; len <= n; len++) {
          for (int i = 0; i + len - 1 < n; i++) {
              int j = i + len - 1;
              if (len == 1) {
                  dp[i][j] = 1;
              } else {
                  dp[i][j] = Integer.MAX_VALUE;
                  for (int k = i; k < j; k++) {
                      if (s.charAt(k) == s.charAt(j)) {
                          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]-1);
                      } else {
                          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                      }
                  }
              }
          }
      }
      
      return dp[0][n-1];
  }
}

