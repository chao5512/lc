//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, is it pos
//sible for you to finish all courses? 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is poss
//ible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take c
//ourse 0 you should
//             also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 1 <= numCourses <= 10^5 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
// 
// 👍 3950 👎 179

package oxgnaw.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CourseSchedule{
      public static void main(String[] args) {
           Solution solution = new CourseSchedule().new Solution();
          System.out.println(solution.canFinish(3, new int[][]{}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return true;
        // 对应下标的课程的入度数组
        int[] in = new int[numCourses];
        int courseCount = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        // 所有依赖当前课程的课程
        ArrayList<LinkedList<Integer>> behindOfCur = new ArrayList<>();
        Arrays.stream(prerequisites)
              .forEach(ints ->{
                  in[ints[0]] += 1;
              });
        IntStream.range(0, in.length)
                 .filter(i -> in[i] == 0)
                 .forEach(q::addLast);

        while (!q.isEmpty()) {
            int course = q.poll();
            courseCount ++;
            Arrays.stream(prerequisites)
                  .filter(ints -> ints[1] == course)
                  .filter(ints -> --in[ints[0]] == 0)
                  .forEach(ints ->{
                      q.addLast(ints[0]);
                  });
        }
        return courseCount == numCourses;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

 }