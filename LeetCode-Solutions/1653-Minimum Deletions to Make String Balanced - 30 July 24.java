class Solution {
  public int minimumDeletions(String s) { 
      int deletions = 0;
      int bCount = 0;
      
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'b') {
              bCount++;
          } else {  // s.charAt(i) == 'a'
              deletions = Math.min(deletions + 1, bCount);
          }
      }
      
      return deletions;
  }
}