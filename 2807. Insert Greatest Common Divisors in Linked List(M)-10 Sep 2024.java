/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode insertGreatestCommonDivisors(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      
      ListNode current = head;
      while (current.next != null) {
          int gcd = calculateGCD(current.val, current.next.val);
          ListNode newNode = new ListNode(gcd);
          newNode.next = current.next;
          current.next = newNode;
          current = newNode.next;
      }
      
      return head;
  }
  
  private int calculateGCD(int a, int b) {
      while (b != 0) {
          int temp = b;
          b = a % b;
          a = temp;
      }
      return a;
  }
}