//LEETCODE solution
//approach disscussed in code at every step 


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // answer list
        List<Integer> ans = new ArrayList<>();

        // knows[i] = whether person i knows the secret
        boolean knows[] = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        // sort meetings wrt time cause secret cant travel back in time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // Processing time by time (one timeframe at a time)
        int i = 0;
        while (i < meetings.length) {

            int t = meetings[i][2];

            // creating a batch of all the meeting occuring at time t so that we can process that batch
            List<int[]> batch = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == t) {
                batch.add(meetings[i]);
                i++;
            }

            // forming a connected graph components where each key is connected
            // to all the other persons their in the meeting with
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] ele : batch) {
                int x = ele[0];
                int y = ele[1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            // traverse the graph and add those key that knows the secret into a queue for performing BFS
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            for (int key : graph.keySet()) {
                if (knows[key]) {
                    q.add(key);
                    visited.add(key);
                }
            }

            // now perform bfs and maintain a Set of values that knows secret into a visited Set
            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int val : graph.get(curr)) {
                    if (!visited.contains(val)) {
                        visited.add(val);
                        q.add(val);
                    }
                }
            }

            // now mark all the ele in visited Set as true in knows array
            // they know the secret now
            for (int val : visited) {
                knows[val] = true;
            }
        }

        // now traverse the knows and add the person who know the secret to the ans
        for (int p = 0; p < n; p++) {
            if (knows[p]) {
                ans.add(p);
            }
        }

        return ans;
    }
}
