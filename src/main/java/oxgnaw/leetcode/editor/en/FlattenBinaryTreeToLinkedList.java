//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search 
// 👍 2762 👎 330

package oxgnaw.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList{
      public static void main(String[] args) {
          Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
          // 1,2,5,3,4,null,6
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(5);
          root.left.left = new TreeNode(3);
          root.left.right = new TreeNode(4);
          root.right.right = new TreeNode(6);

          solution.flatten(root);
          LinkedList<TreeNode> treeNodes = new LinkedList<>();
          treeNodes.addLast(root);
          while (!treeNodes.isEmpty()) {
              TreeNode first = treeNodes.pollFirst();
              System.out.println(first.val);
              if(first.left != null) {
                  treeNodes.addLast(first.left);
              }
              if(first.right != null) {
                  treeNodes.addLast(first.right);
              }
          }
      }
/**
 * Definition for a binary tree node.
 */
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        TreeNode curNode = new TreeNode();
        while (!treeNodes.empty()) {
            TreeNode pop = treeNodes.pop();
            curNode.right = pop;
            curNode = pop;
            if(pop.right != null) {
                treeNodes.push(pop.right);
            }
            if(pop.left != null) {
                treeNodes.push(pop.left);
            }
            pop.left = null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }