//Given the coordinates of four points in 2D space, return whether the four poin
//ts could construct a square. 
//
// The coordinate (x,y) of a point is represented by an integer array with two i
//ntegers. 
//
// Example: 
//
// 
//Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//Output: True
// 
//
// 
//
// Note: 
//
// 
// All the input integers are in the range [-10000, 10000]. 
// A valid square has four equal sides with positive length and four equal angle
//s (90-degree angles). 
// Input points have no order. 
// 
//
// 
// Related Topics Math 
// 👍 246 👎 421

package oxgnaw.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ValidSquare {
    public static void main(String[] args) {
        Solution solution = new ValidSquare().new Solution();
        int[] p1 = new int[]{0,0};
        int[] p2 = new int[]{1,1};
        System.out.println(solution.edgeOf(p1, p2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            List<Double> allEdges = getAllEdges(p1, p2, p3, p4);
            if (allEdges.get(0) == 0 || allEdges.get(5) == 0) return false;
            double edge = allEdges.get(0);
            for (int i = 1; i < 3; i++) {
                if (allEdges.get(i) != edge) {
                   return false;
                }
            }
            double longEdge = allEdges.get(5);
            if (allEdges.get(4) != longEdge) {
                return false;
            }

            if (edge * 2 != longEdge) {
                return false;
            }

            return true;
        }

        public List<Double> getAllEdges(int[] p1, int[] p2, int[] p3, int[] p4){
            double edgeA = edgeOf(p1, p2);
            double edgeB = edgeOf(p1, p3);
            double edgeC = edgeOf(p2, p3);
            double edgeD = edgeOf(p1, p4);
            double edgeE = edgeOf(p4, p2);
            double edgeF = edgeOf(p4, p3);
            ArrayList<Double> edges = new ArrayList<>(6);
            edges.add(edgeE);
            edges.add(edgeA);
            edges.add(edgeB);
            edges.add(edgeC);
            edges.add(edgeD);
            edges.add(edgeF);
            Collections.sort(edges);
            return edges;
        }

        public double edgeOf(int[] p1, int[] p2){
            return Math.pow(p1[1] - p2[1], 2) + Math.pow(p1[0] - p2[0], 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}