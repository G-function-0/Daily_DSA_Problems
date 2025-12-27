//LEETCODE solution 
/*

Approach O(n2) : 
    Let me guide you First for the recursive tree 
        then dry sun the call stack and fill the memoized array 
            and then Try to for the Tabulation approach 
                I HONESTLY CAN NOT DIGEST THE tabulation app for dp problems but after following above 3 steps 
            I derived the tabulation my self and it felt NICE, frustating at first but nice Trust me!

            take text1= abcde and text2 = ace and DIY
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp [][] = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j= 0; j < m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] =0;
                }
            }
        }

        for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                //matched 
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                //unmatched
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}