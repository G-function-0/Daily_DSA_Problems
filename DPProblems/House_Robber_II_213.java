//LEETCODE solution 
/*
Approach : its simple if you know House Robber 1
    you just have to use the function of house robber 1 2 times 
        1st for the range 0 to n-2 i.e. we include 0 index so we cannt include last index 
        2ndly for the range 1 to n-1 i.e. we exclude [0] and include [n-1]
        simple!!
*/



class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        for(int i =0;i<n;i++){
            dp1[i] = -1;
            dp2[i] = -1;
        }
        int ans = Math.max(maxR(0,dp1,nums,n-1),maxR(1,dp2,nums,n));
        return ans;
    }

    public static int maxR(int i, int dp[], int num[],int l){

        if(i>=l){
            return 0;
        }
        //dp check
        if(dp[i] != -1){
            return dp[i];
        }
        int in = num[i]+maxR(i+2,dp,num,l);
        int ex = maxR(i+1,dp,num,l);
        dp[i] = Math.max(in,ex);
        return dp[i];
    }
}
