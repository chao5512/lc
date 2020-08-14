//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming 
// 👍 7444 👎 557

package oxgnaw.leetcode.editor.en;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.isPalindromic("abaaa", 0, 2));
        System.out.println(solution.isPalindromic("abaaa", 0, 1));
        System.out.println(solution.isPalindromic("a", 0, 0));
        System.out.println(solution.longestPalindrome("abbaaa"));
        System.out.println(solution.longestPalindrome("a"));
        long start = System.currentTimeMillis();
        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        System.out.println("time cost : " + (System.currentTimeMillis() - start));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) return s;
            int startPos = 0;
            int len = 0;
            int left;
            int right;
            for (int i = 0; i < s.length(); i++) {
                left = right = i;
                while ((left - 1) >= 0 && (right + 1) < s.length() && s.charAt(left - 1) == s.charAt(right + 1)){
                    left --;
                    right ++;
                }
                //System.out.println("len :" + len);
                //System.out.println("left :" + left + "right : " + right);
                if ((right - left + 1) > len) {
                    startPos =  left;
                    len = right - left + 1;
                }

                left = right = i;
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    right ++;
                }

                while ((left - 1) >= 0 && (right + 1) < s.length() && s.charAt(left - 1) == s.charAt(right + 1)){
                    left --;
                    right ++;
                }

                if ((right - left + 1) > len) {
                    startPos =  left;
                    len = right - left + 1;
                }
            }
            return s.substring(startPos, startPos + len);
        }

        public boolean isPalindromic(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left ++;
                right --;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}