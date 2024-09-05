class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int directionIndex = 0;
      
      int x = 0, y = 0;
      
      int maxDistanceSquared = 0;
      
      Set<String> obstacleSet = new HashSet<>();
      for (int[] obstacle : obstacles) {
          obstacleSet.add(obstacle[0] + "," + obstacle[1]);
      }
      
      for (int cmd : commands) {
          if (cmd == -2) {
              directionIndex = (directionIndex - 1 + 4) % 4;
          } 
          else if (cmd == -1) {
              directionIndex = (directionIndex + 1) % 4;
          } else {
              for (int step = 0; step < cmd; step++) {
                  int nextX = x + directions[directionIndex][0];
                  int nextY = y + directions[directionIndex][1];
                  
                  if (obstacleSet.contains(nextX + "," + nextY)) {
                      break;
                  }
                  
                  
                  x = nextX;
                  y = nextY;
                  
                  maxDistanceSquared = Math.max(maxDistanceSquared, x*x + y*y);
              }
          }
      }
      
      return maxDistanceSquared;
  }
}

