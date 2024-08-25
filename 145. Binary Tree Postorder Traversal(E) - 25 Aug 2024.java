/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      postorderRecursive(root, result);
      return result;
  }
  
  private void postorderRecursive(TreeNode node, List<Integer> result) {
      if (node == null) {
          return;
      }
      postorderRecursive(node.left, result);
      postorderRecursive(node.right, result);
      result.add(node.val);
  }

  public List<Integer> postorderTraversalIterative(TreeNode root) {
      LinkedList<Integer> result = new LinkedList<>();
      if (root == null) {
          return result;
      }
      
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      
      while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          result.addFirst(node.val);
          
          if (node.left != null) {
              stack.push(node.left);
          }
      }
      
      return result;
  }
}

