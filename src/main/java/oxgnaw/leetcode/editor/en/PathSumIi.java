//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 1755 👎 65

package oxgnaw.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PathSumIi {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n24 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        root.left = n4;
        root.right = n8;
        n4.left = n11;
        n8.left = n13;
        n8.right = n24;
        n11.left = n7;
        n11.right = n2;
        n24.left = n5;
        n24.right = n1;
        Solution solution = new PathSumIi().new Solution();
        System.out.println(solution.pathSum(root, 22).size());
        System.out.println(solution.pathSum(null, 1).size());
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            ArrayList<List<Integer>> result = new ArrayList();
            if(root == null) return result;
            ArrayList<Integer> vals = new ArrayList<>();
            Stack<TreeNode> treeNodes = new Stack<>();
            treeNodes.push(root);
            int s = 0;
            while (!treeNodes.empty()) {
                TreeNode pop = treeNodes.pop();
                // 回溯的时候碰倒占位符从和数减去最后一个值
                if(pop == null){
                    Integer remove = vals.remove(vals.size() - 1);
                    s -= remove;
                    continue;
                }
                // 用null占位每个被拆分的父节点
                treeNodes.push(null);
                if (pop.right != null) {
                    treeNodes.push(pop.right);
                }
                if (pop.left != null) {
                    treeNodes.push(pop.left);
                }
                vals.add(pop.val);
                s += pop.val;
                if (isLeaf(pop)) {
                    if (s == sum) {
                        ArrayList<Integer> tmp = new ArrayList<>(vals);
                        result.add(tmp);
                    }
                    s -= pop.val;
                    treeNodes.pop();
                    vals.remove(vals.size() - 1);
                }
            }
            return result;
        }

        private boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}