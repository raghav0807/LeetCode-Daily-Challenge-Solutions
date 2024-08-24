class Solution {
  public String nearestPalindromic(String n) {
      int len = n.length();
      
      if (len == 1) {
          return String.valueOf(Integer.parseInt(n) - 1);
      }
      
      long num = Long.parseLong(n);
      long[] candidates = new long[5];
      
      candidates[0] = (long)Math.pow(10, len) + 1; 
      
      candidates[1] = (long)Math.pow(10, len - 1) - 1; 
      
      long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
      candidates[2] = getMirroredPalindrome(prefix, len % 2 == 0);
      
      candidates[3] = getMirroredPalindrome(prefix - 1, len % 2 == 0);
      
      candidates[4] = getMirroredPalindrome(prefix + 1, len % 2 == 0);
      
      long closest = -1;
      for (long candidate : candidates) {
          if (candidate != num) {
              if (closest == -1 ||
                  Math.abs(candidate - num) < Math.abs(closest - num) ||
                  (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                  closest = candidate;
              }
          }
      }
      
      return String.valueOf(closest);
  }

  private long getMirroredPalindrome(long prefix, boolean evenLength) {
      StringBuilder sb = new StringBuilder(String.valueOf(prefix));
      String suffix = evenLength ? sb.reverse().toString() : sb.reverse().toString().substring(1);
      return Long.parseLong(sb.reverse().append(suffix).toString());
  }
}
