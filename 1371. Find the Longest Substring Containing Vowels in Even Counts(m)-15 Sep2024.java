class Solution {
  public int findTheLongestSubstring(String s) {
      Map<Integer, Integer> seen = new HashMap<>();
      seen.put(0, -1);
      
      int result = 0;
      int state = 0;
      String vowels = "aeiou";

      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          
          int index = vowels.indexOf(c);
          if (index >= 0) {
              state ^= (1 << index);
          }
          
          if (seen.containsKey(state)) {
              result = Math.max(result, i - seen.get(state));
          } else {
              seen.put(state, i);
          }
      }
      
      return result;
  }
}