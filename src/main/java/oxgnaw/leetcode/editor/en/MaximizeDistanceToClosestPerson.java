//In a row of seats, 1 represents a person sitting in that seat, and 0 represent
//s that the seat is empty. 
//
// There is at least one empty seat, and at least one person sitting. 
//
// Alex wants to sit in the seat such that the distance between him and the clos
//est person to him is maximized. 
//
// Return that maximum distance to closest person. 
//
// 
// Example 1: 
//
// 
//Input: [1,0,0,0,1,0,1]
//Output: 2
//Explanation: 
//If Alex sits in the second open seat (seats[2]), then the closest person has d
//istance 2.
//If Alex sits in any other open seat, the closest person has distance 1.
//Thus, the maximum distance to the closest person is 2. 
//
// 
// Example 2: 
//
// 
//Input: [1,0,0,0]
//Output: 3
//Explanation: 
//If Alex sits in the last seat, the closest person is 3 seats away.
//This is the maximum distance possible, so the answer is 3.
// 
// 
// 
//
// 
// Constraints: 
//
// 
// 2 <= seats.length <= 20000 
// seats contains only 0s or 1s, at least one 0, and at least one 1. 
// 
// Related Topics Array 
// 👍 780 👎 106

package oxgnaw.leetcode.editor.en;

import java.util.Arrays;

public class MaximizeDistanceToClosestPerson{
      public static void main(String[] args) {
          Solution solution = new MaximizeDistanceToClosestPerson().new Solution();
          System.out.println(solution.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
          System.out.println(solution.maxDistToClosest(new int[]{1,0,0,0}));
          System.out.println(3/2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int count = 0;
        for (int seat : seats) {
            if(seat == 1){
                break;
            }
            maxDistance ++;
        }
        for (int i = maxDistance; i < seats.length; i++) {
            if(seats[i] == 1) {
                maxDistance = Math.max(maxDistance, count/2);
                count = 1;
                continue;
            }
            count++;
            if(i == seats.length - 1) {
                maxDistance = Math.max(maxDistance, count - 1);
            }
        }
        return maxDistance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }