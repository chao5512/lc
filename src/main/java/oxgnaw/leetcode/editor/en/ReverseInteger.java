//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math 
// 👍 3570 👎 5611

package oxgnaw.leetcode.editor.en;

import java.util.ArrayList;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(900));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            ArrayList<Integer> integers = new ArrayList<>();
            int count = 0;
            while (x / 10 != 0){
                integers.add((x % 10));
                x = x / 10;
                count ++;
            }
            integers.add(x);
            int result = 0;
            double tmp;
            for (Integer integer : integers) {
                tmp =  Math.pow(10, count) * integer + result;
                if(tmp < Math.pow(-2, 31) || tmp > Math.pow(2, 31) -1) return 0;
                result += (integer * (int)Math.pow(10, count));
                count--;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}