// Problem Statement
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order
Each node contains a single digit
Add the two numbers and return the sum as a linked list

Solution:

You may assume:
The numbers do not contain leading zero, except the number 0 itself.
✨ Examples
Example 1
Input:  l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8] {[2+5], [4+6], [3+4]}
Explanation:
342 + 465 = 807


Algorithm (Step-by-Step)
1. Create a dummy node to store the result list
2. Initialize a pointer current pointing to dummy
3. Initialize carry = 0
4. Traverse both linked lists until both become null
5. For each step:
  a. Get values from both lists (0 if null)
  b. Compute sum = val1 + val2 + carry
  c. Update carry = sum / 10
  d. Create a new node with value sum % 10
6. After traversal, if carry > 0, add a new node
7. Return dummy.next

Code:
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            // Get current values or 0 if list ended
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // Calculate sum and carry
            int sum = x + y + carry;
            carry = sum / 10;
            // Create new node with digit part
            current.next = new ListNode(sum % 10);
            current = current.next;
            // Move pointers
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // If carry remains, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        // Return result list (excluding dummy node)
        return dummy.next;
    }
}
