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



// 2134. Minimum Swaps to Group All 1's Together II
// Solved
// Medium

// A swap is defined as taking two distinct positions in an array and swapping the values in them.

// A circular array is defined as an array where we consider the first element and the last element to be adjacent.

// Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.

 

// Example 1:

// Input: nums = [0,1,0,1,1,0,0]
// Output: 1
// Explanation: Here are a few of the ways to group all the 1's together:
// [0,0,1,1,1,0,0] using 1 swap.
// [0,1,1,1,0,0,0] using 1 swap.
// [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
// There is no way to group all 1's together with 0 swaps.
// Thus, the minimum number of swaps required is 1.
// Example 2:

// Input: nums = [0,1,1,1,0,0,1,1,0]
// Output: 2
// Explanation: Here are a few of the ways to group all the 1's together:
// [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
// [1,1,1,1,1,0,0,0,0] using 2 swaps.
// There is no way to group all 1's together with 0 or 1 swaps.
// Thus, the minimum number of swaps required is 2.
// Example 3:

// Input: nums = [1,1,0,0,1]
// Output: 0
// Explanation: All the 1's are already grouped together due to the circular property of the array.
// Thus, the minimum number of swaps required is 0.



// ********************************
// To solve this problem, we can use the sliding window technique.
// Let's break down the solution:

// We first count the total number of 1's in the array.
// We handle edge cases where all elements are 0 or all are 1.
// We create a circular array by duplicating the original array.
// We initialize our window by counting the number of 0's in the first window of size totalOnes.
// We then slide the window through the circular array, updating the count of 0's in the window.
// At each step, we update minSwaps if we find a window with fewer 0's.
// The final value of minSwaps is our answer.

// Time Complexity: O(n), where n is the length of the input array. We make two passes through the array.
// Space Complexity: O(n) to create the circular array.