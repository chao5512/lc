//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle c
//ontaining only 1's and return its area. 
//
// Example: 
//
// 
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
// 
// Related Topics Array Hash Table Dynamic Programming Stack 
// 👍 2935 👎 71
/**
 * after 84
 */

package oxgnaw.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle{
      public static void main(String[] args) {
           Solution solution = new MaximalRectangle().new Solution();
           int[] a = new int[]{1,0,1,0,0};
           int[] b = new int[]{1,0,1,1,1};
           int[] c = new int[]{1,1,1,1,1};
           int[] d = new int[]{1,0,0,1,0};
           int[][] matrix = new int[][]{a,b,c,d};

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if( matrix.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] rectangle = new int[matrix[0].length];
            for (int j = 0; j < matrix[i].length; j++) {
                int height = 0;
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '1') {
                        height++;
                    } else {
                        k = 0;
                    }
                }
                rectangle[j] = height;
            }
            result = Math.max(largestRectangleArea(rectangle), result);
        }
        return result;
    }

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