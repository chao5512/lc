//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 7488 👎 1181

package oxgnaw.leetcode.editor.en;
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
          System.out.println(solution.findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        if(nums1 == null && nums2 == null){
            return 0;
        }

        if(nums2 == null || nums2.length == 0){
            nums2 = nums1;
            nums1 = null;

        }
        if(nums1 == null || nums1.length == 0){
            return nums2.length % 2 != 0 ? nums2[nums2.length / 2]:
                ((double)nums2[nums2.length/2] + (double)nums2[nums2.length/2 - 1])/2;
        }
        int totalLen = nums1.length + nums2.length;
        int[] result = new int[totalLen];
        int cur1 = 0;
        int cur2 = 0;
        for (int i = 0; i < totalLen; i++) {
            if (cur1 == nums1.length) {
                result[i] = nums2[cur2];
                cur2 ++;
                continue;
            }
            if (cur2 == nums2.length) {
                result[i] = nums1[cur1];
                cur1 ++;
                continue;
            }
            if (cur1 < nums1.length && nums1[cur1] <= nums2[cur2]) {
                result[i] = nums1[cur1];
                cur1 ++ ;
            } else {
                result[i] = nums2[cur2];
                cur2 ++;
            }
        }
        if (totalLen % 2 != 0) {
            median = result[totalLen / 2];
        } else {
            median = ((double) result[totalLen / 2 - 1] + (double) result[totalLen / 2]) /2;
        }
     return median;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }