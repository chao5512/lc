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
        System.out.println(solution.rob(new int[]{2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if(len == 1) return nums[0];
            if (len < 2){
                return 0;
            }
            return Math.max(robit(1, len - 1, nums), robit(0, len - 2, nums));
        }

        private int robit(int start, int end, int[] nums) {
            if (end < start) return 0;
            //if (end == start) return nums[end];
            return Math.max(robit(start, end - 1, nums), robit(start, end - 2, nums) + nums[end]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}