class Solution {
  public boolean canBeEqual(int[] target, int[] arr) {
      if (target.length != arr.length) {
          return false;
      }
      
      int[] freq = new int[1001]; 
      
      for (int i = 0; i < target.length; i++) {
          freq[target[i]]++;
          freq[arr[i]]--;
      }
      
      for (int f : freq) {
          if (f != 0) {
              return false;
          }
      }
      
      return true;
  }
}
