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
        System.out.println(solution.longestPalindrome("abaaa"));
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
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i; j < s.length(); j++) {
                    if (isPalindromic(s, i, j) && j - i + 1 > len) {
                        startPos = i;
                        len = j - i + 1;
                    }
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