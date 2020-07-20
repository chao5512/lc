//In a deck of cards, each card has an integer written on it. 
//
// Return true if and only if you can choose X >= 2 such that it is possible to 
//split the entire deck into 1 or more groups of cards, where: 
//
// 
// Each group has exactly X cards. 
// All the cards in each group have the same integer. 
// 
//
// 
// Example 1: 
//
// 
//Input: deck = [1,2,3,4,4,3,2,1]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
// 
//
// Example 2: 
//
// 
//Input: deck = [1,1,1,2,2,2,3,3]
//Output: false´
//Explanation: No possible partition.
// 
//
// Example 3: 
//
// 
//Input: deck = [1]
//Output: false
//Explanation: No possible partition.
// 
//
// Example 4: 
//
// 
//Input: deck = [1,1]
//Output: true
//Explanation: Possible partition [1,1].
// 
//
// Example 5: 
//
// 
//Input: deck = [1,1,2,2,2,2]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[2,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= deck.length <= 10^4 
// 0 <= deck[i] < 10^4 
// 
// Related Topics Array Math 
// 👍 510 👎 127
/**
 * 求几个数的最大公约数g，只须遍历一遍，从前向后求g和下一个数的最大公约数，然后赋值给g既可
 */

package oxgnaw.leetcode.editor.en;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Solution solution = new XOfAKindInADeckOfCards().new Solution();
        System.out.println(solution.hasGroupsSizeX(
            new int[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 9, 10, 11, 11, 11, 12, 13, 14, 15, 16, 17}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {

            int[] bitmap = new int[10000];
            for (int i : deck) {
                bitmap[i] = bitmap[i] + 1;
            }

            // 最大公约数
            int g = 0;

            for (int i = 0; i < bitmap.length; i++) {
                if (bitmap[i] == 0) {
                    continue;
                }
                if (g == 0) {
                    g = bitmap[i];
                } else {
                    g = getGCD(bitmap[i], g);
                }
            }
            return g >= 2;
        }

        /**
         * get great common divisor
         *
         * @return gcd
         */
        private int getGCD(int i, int j) {
            if (j == 0) {
                return i;
            }
            int tmp = i % j;
            return getGCD(j, tmp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}