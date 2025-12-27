//LEETCODE solution 
/*
Approach O(n2) : 
        Simple do 1143 LCS problem first then 
         and only then 
            find Longest COmmon Subsequence in the to strings 
                delete the rest of the letters in string1 and add ne letters from string1 to string2 
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][]  = new int [n+1][m+1];
        for(int i = 1;i < n+1 ;i++){
            for(int j =1;j < m+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        int common = dp[n][m];
        return ((m-common)+(n-common));
    }
}