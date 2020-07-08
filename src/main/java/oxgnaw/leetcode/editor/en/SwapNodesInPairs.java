//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List 
// 👍 2242 👎 169

package oxgnaw.leetcode.editor.en;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }

    class ListNode {
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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode header = new ListNode();
            header.next = head;
            ListNode cur = header;
            while (cur.next != null && cur.next.next != null) {
                swap(cur, cur.next, cur.next.next);
                cur = cur.next.next;
            }
            return header.next;
        }

        void swap (ListNode left, ListNode mid, ListNode right) {
            mid.next = right.next;
            right.next = mid;
            left.next = right;
        }
    }




//leetcode submit region end(Prohibit modification and deletion)

}