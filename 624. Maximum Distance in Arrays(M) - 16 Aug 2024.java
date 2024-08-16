class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
      int result = 0;
      int min = arrays.get(0).get(0);
      int max = arrays.get(0).get(arrays.get(0).size() - 1);
      
      for (int i = 1; i < arrays.size(); i++) {
          List<Integer> currentArray = arrays.get(i);
          int currentMin = currentArray.get(0);
          int currentMax = currentArray.get(currentArray.size() - 1);
          
          result = Math.max(result, Math.max(Math.abs(currentMax - min), Math.abs(max - currentMin)));
          
          min = Math.min(min, currentMin);
          max = Math.max(max, currentMax);
      }
      
      return result;
  }
}


