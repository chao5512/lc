//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack 
// 👍 3895 👎 88

package oxgnaw.leetcode.editor.en;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2 ,2, 1, }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            int j, k;
            for (int i = 0; i < heights.length; i++) {
                j = k = i;
                while (--j > -1 && heights[j] >= heights[i]) {
                }
                while (++k < heights.length && heights[k] >= heights[i]){
                }
                max = Math.max(max, (k - j - 1) * heights[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}