//There are n cities connected by m flights. Each flight starts from city u and 
//arrives at v with a price w. 
//
// Now given all the cities and flights, together with starting city src and the
// destination dst, your task is to find the cheapest price from src to dst with u
//p to k stops. If there is no such route, output -1. 
//
// 
//Example 1:
//Input: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//Output: 200
//Explanation: 
//The graph looks like this:
//
//
//The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as mar
//ked red in the picture. 
//
// 
//Example 2:
//Input: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//Output: 500
//Explanation: 
//The graph looks like this:
//
//
//The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as mar
//ked blue in the picture.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes n will be in range [1, 100], with nodes labeled from 0 to
// n - 1. 
// The size of flights will be in range [0, n * (n - 1) / 2]. 
// The format of each flight will be (src, dst, price). 
// The price of each flight will be in the range [1, 10000]. 
// k is in the range of [0, n - 1]. 
// There will not be any duplicated flights or self cycles. 
// 
// Related Topics Dynamic Programming Heap Breadth-first Search 
// 👍 2036 👎 68

package oxgnaw.leetcode.editor.en;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class CheapestFlightsWithinKStops{
      public static void main(String[] args) {
           Solution solution = new CheapestFlightsWithinKStops().new Solution();
          int[][] ints = new int[6][];
          ints[0] = new int[]{4,1,1};
          ints[1] = new int[]{1,2,3};
          ints[2] = new int[]{0,3,2};
          ints[3] = new int[]{0,4,10};
          ints[4] = new int[]{3,1,1};
          ints[5] = new int[]{1,4,3};

          System.out.println(solution.findCheapestPrice(5, ints, 2, 1, 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        boolean enableLog = false;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            tmp[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        flights = tmp;
        if(enableLog) {
            System.out.println("convert the flight to a table ：int[src][dst]= price");
            print(flights);
        }
        int[][] priceTodst = new int[K + 1][n];
        // fill cost to dst from every city
        for(int j = 0; j < n; j++) {
            priceTodst[0][j] = flights[j][dst];
        }
        if(enableLog){
            System.out.println("arrive with out any stop");
            print(priceTodst);
        }
        int min;
        // f(x)
        for(int i = 1; i < K + 1; i++){
            for(int j = 0; j < n; j++) {
                min = flights[j][dst];
                for(int k = 0; k < n; k++){
                    if(j == k) continue;
                    if(flights[j][k] == 0 || priceTodst[i - 1][k] == 0) continue;

                    min = Math.min(min == 0 ? Integer.MAX_VALUE : min, priceTodst[i-1][k] + flights[j][k]);
                    //System.out.println(priceTodst[i-1][k] + flights[j][k]);
                }
                //print(priceTodst);
                //System.out.println("====");
                priceTodst[i][j] = min == 10001 ? -1 : min;
            }
            if(enableLog) {
                System.out.println("arrive in " + i + "stops");
                print(priceTodst);
            }
        }
        return priceTodst[K][src] == 0 ? -1 : priceTodst[K][src];
    }

    private void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }