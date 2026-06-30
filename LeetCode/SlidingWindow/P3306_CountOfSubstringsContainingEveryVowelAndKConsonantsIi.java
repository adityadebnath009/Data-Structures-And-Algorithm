/**
 * Platform: LeetCode
 * Problem ID: 3306
 * Problem Name: Count of Substrings Containing Every Vowel and K Consonants II
 * You are given a string word and a non-negative integer k.
 *
 * Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u')
 * at least once and exactly k consonants.
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3306_CountOfSubstringsContainingEveryVowelAndKConsonantsIi {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3306_CountOfSubstringsContainingEveryVowelAndKConsonantsIi...");
    }

    // TODO: Write solution method here

        public boolean isVowel(char ch)
        {
            return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
        }
        public long countOfSubstrings(String s, int k) {
            int n = s.length();
            int nextConsonant[] = new int[n];

            int lastIndex = n;
            for(int i = n-1;i >= 0;i--)
            {
                nextConsonant[i] = lastIndex;
                if(!isVowel(s.charAt(i)))
                {
                    lastIndex = i;
                }
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0; //left
            int j = 0;//right

            int cons = 0;
            long res = 0;

            while(j < n)
            {
                char ch = s.charAt(j);
                if(isVowel(ch))
                {
                    map.put(ch, map.getOrDefault(ch,0)+1);
                }
                else
                {
                    cons++;
                }

                while(cons > k)
                {
                    char chi = s.charAt(i);
                    if(isVowel(chi))
                    {
                        map.put(chi, map.get(chi) - 1);
                        if(map.get(chi)==0)
                        {
                            map.remove(chi);
                        }
                    }
                    else
                    {
                        cons--;
                    }
                    i++;
                }
                while(cons ==k && map.size() == 5)
                {
                    res += nextConsonant[j] - j;


                    char chi = s.charAt(i);
                    if(isVowel(chi))
                    {
                        map.put(chi, map.get(chi) - 1);
                        if(map.get(chi)==0)
                        {
                            map.remove(chi);
                        }
                    }
                    else
                    {
                        cons--;
                    }
                    i++;


                }
                j++;


            }
            return res;
        }

}
