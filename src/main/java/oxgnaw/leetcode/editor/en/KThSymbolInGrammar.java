//On the first row, we write a 0. Now in every subsequent row, we look at the pr
//evious row and replace each occurrence of 0 with 01, and each occurrence of 1 wi
//th 10. 
//
// Given row N and index K, return the K-th indexed symbol in row N. (The values
// of K are 1-indexed.) (1 indexed). 
//
// 
//Examples:
//Input: N = 1, K = 1
//Output: 0
//
//Input: N = 2, K = 1
//Output: 0
//
//Input: N = 2, K = 2
//Output: 1
//
//Input: N = 4, K = 5
//Output: 1
//
//Explanation:
//row 1: 0
//row 2: 01
//row 3: 0110
//row 4: 01101001
// 
//
// Note: 
//
// 
// N will be an integer in the range [1, 30]. 
// K will be an integer in the range [1, 2^(N-1)]. 
// 
// Related Topics Recursion 
// 👍 472 👎 143

package oxgnaw.leetcode.editor.en;
  public class KThSymbolInGrammar{
      public static void main(String[] args) {
           Solution solution = new KThSymbolInGrammar().new Solution();
          System.out.println(solution.kthGrammar(2,2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1){
            return 0;
        }
        int preK = (K + 1) / 2;
        int eqPreK = K % 2;

        if (eqPreK == 1) {
            return kthGrammar(N - 1, preK);
        } else {
            return kthGrammar(N - 1, preK) == 0 ? 1 : 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }