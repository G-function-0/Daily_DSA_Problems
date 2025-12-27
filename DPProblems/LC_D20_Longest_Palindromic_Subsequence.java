//LEETCode solution 
/*
Approach O(n2) : 
    so the approach is simple do 1143 LCS problem first then 
        only then 
            take a String s2 which is reverse of s 
                find the longest common subseqence and thats the Longest Palindromic Subsequence simple and strightforward 
*/


class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        int n = s.length();

        for(int i = n-1;i >=0;i-- ){
            s2 += String.valueOf(s.charAt(i));
        }
        int dp [][] = new int[n+1][n+1];
        for(int i =1; i<n+1;i++){
            for(int j =1;j<n+1;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }

            }
        }

        return dp[n][n];
    }
}