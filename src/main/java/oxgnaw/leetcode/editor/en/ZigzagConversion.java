//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
// Related Topics String 
// 👍 1766 👎 4770

package oxgnaw.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("abcde", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < s.length(); j += (numRows - 1) * 2) {
                    // first candidate
                    if (j + i < s.length()) {
                        sb.append(s.charAt(j + i));
                    }
                    int next = j + (numRows - 1) * 2;
                    // second candidate
                    int secondCandidate = j + 2 * numRows -i -2;
                    if (secondCandidate == (j + i) || secondCandidate == next)continue;
                    if(secondCandidate < s.length()) {
                        sb.append(s.charAt(secondCandidate));
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}