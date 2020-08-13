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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2 ,2, 1, }));
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(solution.largestRectangleArea(new int[]{2,1,2}));
        System.out.println(solution.largestRectangleArea(new int[]{5,4,1,2}));
        System.out.println(solution.largestRectangleArea(new int[]{4,2,0,3,2,5}));
        System.out.println(solution.largestRectangleArea(new int[]{3,2,5}));
        System.out.println(solution.largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if(heights.length == 0) return 0;
            if(heights.length == 1) return heights[0];
            Deque<Integer> pos = new ArrayDeque<>();
            int result = 0;
            pos.push(0);
            int tmp = 0;
            for (int i = 1; i < heights.length; i++) {
                if (heights[i] < heights[pos.peek()]) {
                    while (!pos.isEmpty() && heights[pos.peek()] > heights[i]) {
                        tmp = pos.pop();
                        int width = pos.isEmpty() ? i  : i - pos.peek() - 1;
                        result = Math.max(result, heights[tmp] * width);
                    }
                }
                pos.push(i);
            }
            int theLastPos = heights.length;
            while (!pos.isEmpty()) {
                tmp = pos.pop();
                int width = pos.isEmpty() ? theLastPos : theLastPos - pos.peek() - 1;
                result = Math.max(result, width * heights[tmp]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}