//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math 
// 👍 8775 👎 2213

package oxgnaw.leetcode.editor.en;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode n8 = new ListNode(8);
        ListNode n1 = new ListNode(1);
        n1.next = n8;
        System.out.println(solution.addTwoNumbers(n1, new ListNode(5)).val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l2 == null) return l1;
            if(l1 == null) return l2;
            int grownDigit = 0;
            int re = 0;
            ListNode result = new ListNode();
            ListNode root = result;
            while(l1 != null) {
                int tmp;
                if(l2 == null) {
                    tmp = l1.val + grownDigit;
                } else {
                    tmp = l1.val + l2.val + grownDigit;
                    l2 = l2.next;
                }
                grownDigit = tmp / 10;
                re = tmp % 10;
                result.next = new ListNode(re);
                l1 = l1.next;
                result = result.next;
            }

            // l2 still hasnext
            while (l2 != null) {
                int tmp = l2.val + grownDigit;
                grownDigit = tmp / 10;
                re = tmp % 10;
                result.next = new ListNode(re);
                l2 = l2.next;
                result = result.next;
            }
            if (grownDigit != 0) {
                result.next = new ListNode(grownDigit);
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}