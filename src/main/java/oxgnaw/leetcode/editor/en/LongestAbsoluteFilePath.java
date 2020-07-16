//Suppose we abstract our file system by a string in the following manner: 
//
// The string "dir
//\tsubdir1
//\tsubdir2
//\t\tfile.ext" represents: 
//
// dir
//    subdir1
//    subdir2
//        file.ext
// 
//
// The directory dir contains an empty sub-directory subdir1 and a sub-directory
// subdir2 containing a file file.ext. 
//
// The string "dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext" represents: 
//
// dir
//    subdir1
//        file1.ext
//        subsubdir1
//    subdir2
//        subsubdir2
//            file2.ext
// 
//
// The directory dir contains two sub-directories subdir1 and subdir2. subdir1 c
//ontains a file file1.ext and an empty second-level sub-directory subsubdir1. sub
//dir2 contains a second-level sub-directory subsubdir2 containing a file file2.ex
//t. 
//
// We are interested in finding the longest (number of characters) absolute path
// to a file within our file system. For example, in the second example above, the
// longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 
//32 (not including the double quotes). 
//
// Given a string representing the file system in the above format, return the l
//ength of the longest absolute path to file in the abstracted file system. If the
//re is no file in the system, return 0. 
//
// Note: 
// 
// The name of a file contains at least a . and an extension. 
// The name of a directory or sub-directory will not contain a .. 
// 
// 
//
// Time complexity required: O(n) where n is the size of the input string. 
//
// Notice that a/aa/aaa/file1.txt is not the longest file path, if there is anot
//her path aaaaaaaaaaaaaaaaaaaaa/sth.png. 👍 592 👎 1406

package oxgnaw.leetcode.editor.en;

import java.util.HashMap;
import java.util.Stack;

public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        Solution solution = new LongestAbsoluteFilePath().new Solution();
        /**
         * 测试结果:9
         * 期望结果:20
         */
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(solution.lengthLongestPath("a"));
        System.out.println(solution.lengthLongestPath("dir\n\tfile.txt"));
        System.out.println(solution.lengthLongestPath("dir\n    file.txt"));
        System.out.println((int) ".".charAt(0));
        System.out.println(solution.lengthLongestPath(
            "sladjf\n\tlkjlkv\n\t\tlkjlakjlert\n\t\t\tlaskjglaksjf\n\t\t\t\tlakjgfljrtlj\n\t\t\t\t\tlskajflakjsvlj\n\t\t\t\t\t\tlskgjflkjrtlrjt\n\t\t\t\t\t\t\tlkjglkjlvkjdlvkj\n\t\t\t\t\t\t\t\tlfjkglkjfljdlv\n\t\t\t\t\t\t\t\t\tlkdfjglerjtkrjkljsd.lkvjlkajlfk\n\t\t\t\t\t\t\tlskfjlksjljslvjxjlvkzjljajoiwjejlskjslfj.slkjflskjldfkjoietruioskljfkljf\n\t\t\t\t\tlkasjfljsaljlxkcjzljvl.asljlksaj\n\t\t\t\tasldjflksajf\n\t\t\t\talskjflkasjlvkja\n\t\t\t\twioeuoiwutrljsgfjlskfg\n\t\t\t\taslkjvlksjvlkjsflgj\n\t\t\t\t\tlkvnlksfgk.salfkjaslfjskljfv\n\t\t\tlksdjflsajlkfj\n\t\t\tlasjflaskjlk\n\t\tlsakjflkasjfkljas\n\t\tlskjvljvlkjlsjfkgljfg\n\tsaljkglksajvlkjvkljlkjvksdj\n\tlsakjglksajkvjlkjdklvj\n\tlskjflksjglkdjbkljdbkjslkj\n\t\tlkjglkfjkljsdflj\n\t\t\tlskjfglkjdfgkljsdflj\n\t\t\t\tlkfjglksdjlkjbsdlkjbk\n\t\t\t\t\tlkfgjlejrtljkljsdflgjl\n\t\t\t\t\tsalgkfjlksfjgkljsgfjl\n\t\t\t\t\tsalkflajwoieu\n\t\t\t\t\t\tlaskjfglsjfgljkkvjsdlkjbklds\n\t\t\t\t\t\t\tlasjglriotuojgkjsldfgjsklfgjl\n\t\t\t\t\t\t\t\tlkajglkjskljsdljblkdfjblfjlbjs\n\t\t\t\t\t\t\t\t\tlkajgljroituksfglkjslkjgoi\n\t\t\t\t\t\t\t\t\t\tlkjglkjkljkljdkbljsdfljgklfdj\n\t\t\t\t\t\t\t\t\t\t\tlkjlgkjljgslkdkldjblkj\n\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkjbsdklj.slgfjalksjglkfjglf\n\t\t\t\t\t\t\t\t\t\t\t\tlkasjrlkjwlrjljsl\n\t\t\t\t\t\t\t\t\t\t\t\t\tlksjgflkjfklgjljbljls\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsglkjlkjfkljdklbjkldf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjglkjdlsfjdglsdjgjlxljjlrjsgjsjlk\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsgkllksjfgjljdslfkjlkasjdflkjxcljvlkjsgkljsfg\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlaskjlkjsakljglsdjfgksdjlkgjdlskjb\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkajsgfljfklgjlkdjgfklsdjklj\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkgjlkjl.aslkjflasjlajglkjaf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjasflgjlskjglkfjgklgsdjflkbjsdklfjskldfjgklsfdjgklfdjgl\n\tlskadjlkjsldwwwwwfj\n\t\tlkjflkasjlfjlkjajslfkjlasjkdlfjlaskjalvwwwwwwwwwwwwwwwkjlsjfglkjalsjgflkjaljlkdsjslbjsljksldjlsjdlkjljvblkjlkajfljgasljfkajgfljfjgldjblkjsdljgsldjg.skljf"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            if (!input.contains(".")) {
                return 0;
            }
            // \=92, \t=9, \n=10
            int result = 0;
            boolean isFile = false;
            // current word
            int sum = 0;
            Stack<Integer> wordStack = new Stack();
            int curWord = 0;
            int lastLevel = 0;
            int level = 1;
            for (int i = 0; i < input.length(); i++) {
                while (input.charAt(i) == 9) {
                    level++;
                    i++;
                }
                if (input.charAt(i) == 10 || i == input.length() - 1) {
                    if (i == input.length() - 1) {
                        curWord++;
                    }
                    while (lastLevel >= level) {
                        sum -= wordStack.pop();
                        lastLevel--;
                    }
                    sum += curWord;
                    wordStack.push(curWord);
                    // 注意a/b sum=3 而不是sum=2
                    if(isFile) result = Math.max(result, sum + level - 1);
                    isFile = false;
                    curWord = 0;
                    lastLevel = level;
                    level = 1;
                    continue;
                }
                // 如果当前word中有. 则为文件，此时方可计算长度
                if(input.charAt(i) == 46) {
                    isFile = true;
                }
                curWord += 1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}