package LeetCode.Graphs;

/**
 * Platform: LeetCode
 * Problem ID: 815
 * Problem Name: Bus Routes
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/bus-routes/
 * 
 * Complexity:
 * - Time Complexity: O(V+E)
 * - Space Complexity: O(V+E)
 * 
 * Approach:
 * // TODO:
 * It’s an interesting question.
 * Instead of treating stops as nodes, we treat bus indices as nodes.
 * We mark bus indices as visited using a set; we do not need to mark stops as visited because once a bus is marked visited,
 * we can reach any stop on that bus’s route.
 *
 * Since bus indices are nodes, we use a map that maps each stop to the list of buses that serve it.
 * This allows us to select any bus from a given stop.
 *
 * We maintain a pair (bus_count, bus_index). The count starts at 1 because boarding the first bus counts as one transfer.
 * Initially, we enqueue all buses that can be taken from the source.
 *
 * If a stop equals the target, we return the current bus count. Otherwise, we examine the buses reachable
 * from the current stop and enqueue those that have not yet been visited.
 */

public class P0815_BusRoutes {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0815_BusRoutes...");
    }

    // TODO: Write solution method here
}
class Solution {
    static class Pair
    {
        int bus_index;
        int bus_count;
        Pair(int bus_index, int bus_count)
        {
            this.bus_index = bus_index;
            this.bus_count = bus_count;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();


        for(int i = 0;i < routes.length;i++)
        {
            for(int j = 0;j < routes[i].length;j++)
            {
                map.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        if(map.containsKey(source)==false || map.containsKey(target)==false)
        {
            return -1;
        }
        Queue<Pair> q = new LinkedList<>();
        for(int buses: map.get(source))
        {
            visited.add(buses);
            q.add(new Pair(buses,1));
        }

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int bus_index = p.bus_index;
            int bus_count  = p.bus_count;

            for(int stop : routes[bus_index])
            {
                if(stop==target)
                {
                    return bus_count;
                }
                for(int nextBus: map.get(stop))
                {
                    if(!visited.contains(nextBus))
                    {
                        visited.add(nextBus);
                        q.add(new Pair(nextBus, bus_count + 1));
                    }
                }

            }
        }
        return -1;

    }
}