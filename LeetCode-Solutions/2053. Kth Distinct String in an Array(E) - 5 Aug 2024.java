class Solution {
  public String kthDistinct(String[] arr, int k) {
      Map<String, Integer> frequencyMap = new LinkedHashMap<>();
      
      for (String s : arr) {
          frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
      }
      
      int distinctCount = 0;
      for (String s : frequencyMap.keySet()) {
          if (frequencyMap.get(s) == 1) {
              distinctCount++;
              if (distinctCount == k) {
                  return s;
              }
          }
      }
      
      return "";
  }
}