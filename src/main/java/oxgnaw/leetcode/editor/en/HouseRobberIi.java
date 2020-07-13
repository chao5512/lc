//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have security system connected and it will automatically cont
//act the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2),
//             because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
// Related Topics Dynamic Programming 
// 👍 1719 👎 49

package oxgnaw.leetcode.editor.en;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[] {1,1,1,2}));
        System.out.println(solution.rob(new int[] {2,3,2}));
        System.out.println(solution.rob(new int[] {1,1,1,2}));
        System.out.println(solution.rob(new int[]{1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}));
        System.out.println(solution.rob(new int[] {2,2,4,3,2,5}));
        System.out.println(solution.rob(new int[] {2,7,9,3,1}));
        System.out.println(solution.rob(new int[]{1, 2, 3}));
        System.out.println(solution.rob(new int[]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if(len == 0) return 0;
            if(len == 1) return nums[0];
            // 重点是将环形结构拆分成为2个单链结构，再对单链结构列状态转移方程， 做动态规划
            return Math.max(rob(nums, 0, len - 1), rob(nums, 1, len - 1));
        }

        private int rob(int[] nums, int start, int len) {
            if(len < 2) return nums[start];
            int[] robit = new int[len];
            int[] notrobit = new int[len];
            robit[0] = nums[start];
            for(int i = 0 ; i < len - 1; i++) {
                robit[i + 1] = notrobit[i] + nums[start + i + 1];
                notrobit[i + 1] = Math.max(robit[i], notrobit[i]);
            }
            return Math.max(robit[len - 1], notrobit[len - 1]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}