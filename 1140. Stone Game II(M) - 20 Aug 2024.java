public class Solution {
  public int stoneGameII(int[] piles) {
      int n = piles.length;
      int[][][] dp = new int[n + 1][n + 1][2];
      
      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= n; j++) {
              dp[i][j][0] = dp[i][j][1] = 0;
          }
      }

      int[] suffixSum = new int[n + 1];
      suffixSum[n] = 0;
      for (int i = n - 1; i >= 0; i--) {
          suffixSum[i] = suffixSum[i + 1] + piles[i];
      }

      for (int i = n - 1; i >= 0; i--) {
          for (int M = 1; M <= n; M++) {
              for (int X = 1; X <= 2 * M && i + X <= n; X++) {
                  int opponentStones = dp[i + X][Math.max(M, X)][1];
                  dp[i][M][0] = Math.max(dp[i][M][0], suffixSum[i] - opponentStones);
                  dp[i][M][1] = Math.max(dp[i][M][1], suffixSum[i] - dp[i + X][Math.max(M, X)][0]);
              }
          }
      }

      return dp[0][1][0];
  }
  
  public static void main(String[] args) {
      Solution sol = new Solution();
      int[] piles1 = {2,7,9,4,4};
      System.out.println(sol.stoneGameII(piles1));
      
      int[] piles2 = {1,2,3,4,5,100};
      System.out.println(sol.stoneGameII(piles2)); 
  }
}

