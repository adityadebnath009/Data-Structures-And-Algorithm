/**
 * Platform: LeetCode
 * Problem ID: 1334
 * Problem Name: FlowdWarshall
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/flowdwarshall/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1334_Flowdwarshall {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1334_Flowdwarshall...");
    }

    // TODO: Write solution method here

}

class Solution {
    public int findTheCity(int n, int[][] edges, int distTh) {

        int dist[][] = new int[n][n];

        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(i==j)
                {
                    dist[i][j] = 0;
                }
                else
                {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }


        for(int k = 0;k < n;k++)
        {
            for(int i = 0;i < n;i++)
            {
                for(int j = 0;j < n;j++)
                {
                    if( dist[i][k]!=Integer.MAX_VALUE &&  dist[k][j]!=Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int cnt;
        int largeCityNo = Integer.MIN_VALUE;
        int minCities = Integer.MAX_VALUE;


        //i ---> City
        //j ---> neighCity
        for(int i = 0; i < n;i++)
        {
            cnt = 0;
            int city = i;
            for(int j = 0;j < n;j++)
            {
                if(i==j)
                    continue;

                if(distTh>=dist[i][j])
                {
                    cnt++;
                }

            }
            if(minCities==Integer.MAX_VALUE && largeCityNo==Integer.MIN_VALUE)
            {
                minCities = cnt;
                largeCityNo = city;
            }
            else if(minCities==cnt)
            {
                largeCityNo = Math.max(largeCityNo, city);
            }
            else if(cnt < minCities)
            {
                largeCityNo = city;
                minCities = cnt;
            }

        }

        return largeCityNo;
    }
}
