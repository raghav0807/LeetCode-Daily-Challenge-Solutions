class Solution {
  public int minimumPushes(String word) {
      int[] frequency = new int[26];
      for (char c : word.toCharArray()) {
          frequency[c - 'a']++;
      }
      
      Arrays.sort(frequency);
      
      int totalPushes = 0;
      int keyPushes = 1;
      int keysUsed = 0;
      
      for (int i = 25; i >= 0; i--) {
          if (frequency[i] == 0) break;
          
          totalPushes += frequency[i] * keyPushes;
          keysUsed++;
          
          if (keysUsed % 8 == 0) {
              keyPushes++;
          }
      }
      
      return totalPushes;
  }
}

