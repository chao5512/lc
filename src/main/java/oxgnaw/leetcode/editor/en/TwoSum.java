//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table 
// 👍 15765 👎 576

package oxgnaw.leetcode.editor.en;

import sun.print.SunMinMaxPage;

public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
          System.out.println(solution.twoSum(new int[]{2,7,11,15} , 9));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result =  new int[]{i, j};
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }