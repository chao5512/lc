//You are given an array coordinates, coordinates[i] = [x, y], where [x, y] repr
//esents the coordinate of a point. Check if these points make a straight line in 
//the XY plane. 
//
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//Output: true
// 
//
// Example 2: 
//
// 
//
// 
//Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates contains no duplicate point. 
// 
// Related Topics Array Math Geometry 
// 👍 353 👎 58

package oxgnaw.leetcode.editor.en;
  public class CheckIfItIsAStraightLine{
      public static void main(String[] args) {
           Solution solution = new CheckIfItIsAStraightLine().new Solution();
           int[][] array = new int[3][];
           array[0] = new int[]{2,1};
           array[1] = new int[]{4,2};
           array[2] = new int[]{6,3};
          System.out.println(solution.checkStraightLine(array));
          System.out.println((double)-1/(double)-2);
          System.out.println((double)(1/2));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        double a = 0;
        double b = 0;
        int dx = coordinates[0][0] - coordinates[1][0];
        int dy = coordinates[0][1] - coordinates[1][1];
        if(dx == 0){
            for(int i = 2; i < coordinates.length; i++) {
                if(coordinates[i][0] != coordinates[0][0]) return false;
            }
            return true;
        }
        // try if error
        a = (double)(dy)/(double)(dx);
        b = coordinates[0][1] - a * coordinates[0][0];
        for(int i = 2; i < coordinates.length; i++) {
             if(coordinates[i][1] != coordinates[i][0] * a + b) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }