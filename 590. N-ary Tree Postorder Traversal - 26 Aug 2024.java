public class 590. N-ary Tree Postorder Traversal - 26 Aug 2024 {
  
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<Integer> postorder(Node root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
      
      postorderTraversal(root, result);
      
      return result;
  }
  
  private void postorderTraversal(Node node, List<Integer> result) {
      if (node == null) return;
      
      for (Node child : node.children) {
          postorderTraversal(child, result);
      }
      
      result.add(node.val);
  }
}

