//Write a function that takes a string as input and reverse only the vowels of a
// string. 
//
// Example 1: 
//
// 
//Input: "hello"
//Output: "holle"
// 
//
// 
// Example 2: 
//
// 
//Input: "leetcode"
//Output: "leotcede" 
// 
//
// Note: 
//The vowels does not include the letter "y". 
//
// 
// Related Topics Two Pointers String 
// 👍 711 👎 1165

package oxgnaw.leetcode.editor.en;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("leetcode"));
        System.out.println("leetcode".indexOf('s'));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            String vowels = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int lo = 0;
            int hi = s.length() - 1;
            while (lo < hi) {
                while (vowels.indexOf(chars[hi]) == -1 && lo < hi){
                    hi--;
                }

                while (vowels.indexOf(chars[lo]) == -1 && lo < hi){
                    lo++;
                }
                if(lo == hi) break;
                exchange(chars, lo, hi);
                hi--;
                lo++;
            }

            return String.valueOf(chars);
        }

        private void exchange(char[] chars, int lo, int hi) {
            char tmp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}