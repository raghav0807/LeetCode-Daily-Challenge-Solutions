class Solution {
  public int minSwaps(int[] nums) {
      int n = nums.length;
      int totalOnes = 0;
      
      for (int num : nums) {
          totalOnes += num;
      }
      
      if (totalOnes == 0 || totalOnes == n) {
          return 0;
      }
      
      int[] circular = new int[2 * n];
      for (int i = 0; i < 2 * n; i++) {
          circular[i] = nums[i % n];
      }
      
      int zerosInWindow = 0;
      for (int i = 0; i < totalOnes; i++) {
          if (circular[i] == 0) {
              zerosInWindow++;
          }
      }
      
      int minSwaps = zerosInWindow;
      
      for (int i = totalOnes; i < 2 * n; i++) {
          if (circular[i - totalOnes] == 0) {
              zerosInWindow--;
          }
          if (circular[i] == 0) {
              zerosInWindow++;
          }
          minSwaps = Math.min(minSwaps, zerosInWindow);
      }
      
      return minSwaps;
  }
}