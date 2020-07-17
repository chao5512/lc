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

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList{
      public static void main(String[] args) {
           Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
      }
/**
 * Definition for a binary tree node.
 */
  public class TreeNode {
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
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        TreeNode curNode = root;
        while (!treeNodes.empty()) {
            TreeNode pop = treeNodes.pop();
            curNode.right = pop;
            curNode = pop;
            if(pop.right != null) {
                treeNodes.push(pop.right);
            }
            if(pop.left != null) {
                treeNodes.push(pop.right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }