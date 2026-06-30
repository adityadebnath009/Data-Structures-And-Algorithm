/**
 * Platform: LeetCode
 * Problem ID: 1358
 * Problem Name: Number of Substrings Containing All Three Characters
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Use a sliding window with two pointers.
 * Expand the window to the right, counting 'a', 'b', and 'c'.
 * Whenever the window contains at least one of each ('a', 'b', 'c'),
 * all substrings starting from the left pointer to the end are valid.
 *
 * General Pattern
 *
 * Whenever your sliding window satisfies the condition:
 *
 * Window is valid
 *
 * every larger window obtained by extending the right boundary is also valid.
 *
 * Therefore,
 *
 * Number of valid substrings
 * = n - right
 *
 * instead of checking each one individually.
 * */

public class P1358_NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1358_NumberOfSubstringsContainingAllThreeCharacters...");
    }


    // TODO: Write solution method here
        public int numberOfSubstrings(String s) {

            int len = s.length();
            int i = 0;
            int j = 0;
            //0-->a
            //1-->b
            //2-->c
            int arr[] = new int[3];
            int res = 0;

            while (i < len) {

                char ch = s.charAt(i);
                arr[ch - 'a']++;

                while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                    res += (len - i);
                    arr[s.charAt(j) - 'a']--;
                    j++;
                }


                i++;
            }

            return res;

        }

}
