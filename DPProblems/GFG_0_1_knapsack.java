//Geeks For Geeks solution
/*
Approach O(n2) : Tabulation solution 
    Sorry Not well today, So can't explain this
    Its not tough if you havve figured out the recursive problem and then you know how to convert any recursion into tabulation 
        Let me give you hint 
        So the way if simple 
            after writing recursive solution you take a dp array 
            and initialize it with base case of recursion 
                Like n==0 || W == 0 
                    so dp[i][0] = 0 and dp[0][j] = 0; //initialization done 
                    
        Next is Recursion to Interation COnversion 
        you can do all the things same except tht you treat the Function in Recursion as dp For ex: 
            knapRecrsion(wt,val,n-1,W-wt[n-1]) -> dp[n-1][W-wt[n-1]] but here n -> i and W -> j simple if you understand this 
            you are good ith any dp No Problem

*/

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        Solution obj = new Solution();
        int n = val.length;
        int dp [][] = new int[n+1][W+1];
        for(int i =0;i < n+1;i++ ){
            for(int j=0;j < W+1;j++){
                if(i==0 || j==0)
                dp[i][j] = 0;
            }
        }
        
        for(int i =1;i<n+1;i++){
            for(int j =1;j<W+1;j++){
                int inc = 0,ex=0;
                if(wt[i-1]<=j){
                    //include
                    inc = val[i-1]+dp[i-1][j-wt[i-1]];
                }
                ex = dp[i-1][j];
                dp[i][j] = Math.max(inc,ex);
                
            }
        }
        
        return dp[n][W];
        
    }
    
}

