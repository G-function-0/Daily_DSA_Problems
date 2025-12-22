//LeetCode solution 

/*
Approach O(n2) : 
    Let me rename this problem "2D Longest Increasing Subsequence"
    I would suggest that you solve Longest Increasing Subsequence Problem 300 on LeetCode before this 
    cause after that this problem is totaly similar to that problem
    -> we are doing that L.I.S. thing and then checking in all the strings 
        that does non of them voilate the lexicographical condition in thoes particular row if not we count that and yes 
             and increase the length of dp[i] by 1 
             simple if you know LIS
             
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int col = strs[0].length();
        int dp[] = new int[col];

        for (int i = 0; i < col; i++) {
            dp[i] = 1;
            for (int j = 0; j < i && j>=0; j++) {
                boolean del = false;

                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        del = true;
                        break;
                    }
                }

                if (del) continue;

                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < col; i++) {
            max = Math.max(dp[i], max);
        }

        return col - max;
    }
}
