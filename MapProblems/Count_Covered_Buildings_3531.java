//LEETCODE solution 
/*
Approach O(n) :
    lets see we are using to 2 maps 
    each to track minimum and maximum boundary in each row and col repectively 
    here array refference property came in very handy as you can see 
        now at each point i am checking if current element is at boundary or not if its not on the boundary then we are good ith it and increase result with 1 else continue
*/
import java.util.HashMap;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, int[]> yToMinMaxX = new HashMap<>();
        HashMap<Integer, int[]> xToMinMaxY = new HashMap<>();

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            yToMinMaxX.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xToMinMaxY.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

            int[] xr = yToMinMaxX.get(y);
            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);

            int[] yr = xToMinMaxY.get(x);
            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);
        }

        int result = 0;

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            int[] xr = yToMinMaxX.get(y);
            int[] yr = xToMinMaxY.get(x);

            if (xr[0] < x && x < xr[1] &&
                yr[0] < y && y < yr[1]) {
                result++;
            }
        }

        return result;
    }
}