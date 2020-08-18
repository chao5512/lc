//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math 
// 👍 2433 👎 1581

package oxgnaw.leetcode.editor.en;

import com.sun.org.apache.regexp.internal.RE;
import java.util.ArrayDeque;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            ArrayDeque<Integer> integers = new ArrayDeque<>();
            while (x / 10 != 0){
                integers.add((x % 10));
                x = x / 10;
            }
            integers.add(x);
            int first;
            int last;
            while (!integers.isEmpty()){
                first = integers.getFirst();
                integers.removeFirst();

                if (integers.isEmpty()) return true;
                last = integers.getLast();
                integers.removeLast();
                if(first != last)return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}