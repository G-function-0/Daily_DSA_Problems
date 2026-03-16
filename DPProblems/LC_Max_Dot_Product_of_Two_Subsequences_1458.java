
import java.util.Arrays;

//LEETCODE solution 

/*
Approach O(n x m) : 
    solution is not that hard if you think about it 
        THIS  Q is way similar to LCS longest common subsequence problem 
        
    see at each i , j we have three choices 
        c1 : pair them up that means multiply them and give the answer 
        c2 : skip1 the element in nums1 
        c3 : skip2 the element in nums2
    and we need to maximize the product sum so take MAth.max();

    initialization with Integer.MINALUE?
        this is done because we cant take 0 as the minimum answer so we need to take least possible neagtive value ->  this is not that hard to understan think about it 

    this is how recursion and memoization and some what tabulation works for this question 

    DOnt you think its exactly same as LCS appraoch 
    if you do then you did LCS nicely 
    Congratulations for you HARD question 

*/

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp [][]= new int [n][m];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        
        maxProduct(nums1,nums2,dp,0,0);

        return dp[0][0];
    }

    public static int maxProduct(int nums1[], int nums2[], int dp [][],int i, int j){
        if(i == nums1.length || j == nums2.length){
            return Integer.MIN_VALUE /2;
        }

        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int pair = (nums1[i] * nums2[j]) + Math.max(maxProduct(nums1, nums2, dp, i+1,j+1),0);
        int skip1 = maxProduct(nums1, nums2, dp, i+1,j);
        int skip2 = maxProduct(nums1, nums2, dp, i,j+1);
        return dp[i][j] = Math.max(pair , Math.max(skip1, skip2));
    }
}


//Tabulation Approach 

// class Solution {
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         int n = nums1.length, m = nums2.length;
//         int[][] dp = new int[n+1][m+1];

//         for (int i = 0; i <= n; i++)
//             for (int j = 0; j <= m; j++)
//                 dp[i][j] = Integer.MIN_VALUE / 2;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 int pair = nums1[i-1] * nums2[j-1]
//                            + Math.max(0, dp[i-1][j-1]);
//                 int skip1 = dp[i-1][j];
//                 int skip2 = dp[i][j-1];

//                 dp[i][j] = Math.max(pair, Math.max(skip1, skip2));
//             }
//         }

//         return dp[n][m];
//     }
// }