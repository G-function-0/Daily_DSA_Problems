// LEETCODE solution 
/*
Approach O(n) time space constant :
    its simple think of it as a SEGMENT problem 
        and each segment end hen diff between curr and prev becomes 1 ;
        and in each section we want to calc total no of subarrays ( subarray is contiguous sequestion of number in an array )
            formulae to calc subarray - len * len+1 /2
            and add it to the ans 
            and reset len to 1 to start a ne section 
        (THE subarray part feels trickey if you do not know it already so try to bear with it )            
*/

class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int len = 1;
        long ans = 0;
        
        for(int i=1;i<n;i++){
            if(prices[i-1]-prices[i] == 1){
                len++;
            }
            else{
                long sub =(long)len * (len+1)/2;
                ans +=sub;
                len=1;
            }
        }
        if(len>=1){
            ans += (long)len * (len+1)/2;
        }
        return ans;
    }
}

// DP Approach O(n) time and space:
    //already explain thie code 






class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 0;
        long dp [] = new long [n];
        // initialization 
        dp[0] = 1;
        for(int i =1;i<n;i++){
            if(prices[i-1]-prices[i] == 1){
                //dp[i] -> number of smooth decent period that ends at 'i'
                    // in other word, if we include i into the prev subarray how many subarray we can create
                        // the answer is all the previous subarrays with i and 'i' will also be a subarray 
                            // so their for prev + 1 (1 is for i)
                dp[i] = dp[i-1]+1;
                continue;
            }
            dp[i] = 1;
        }

        // ans calc 
        for(int i =0;i<n;i++){
            ans += dp[i]; 
        }
        return ans;
    }
}