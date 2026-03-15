//Strivers Followup question 

// dp playlist 4th video  : https://youtu.be/Kmh3rhyEtB8?si=uKw0_2pxb0cIr0bz

//MemoizAtion

class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
            // ideally dp array should have -1 at all the places initially
        return energyRequired(k,n-1,heights, new int[n]);
    }

    public int energyRequired(int k, int i,int  heights[], int dp[]){
        if(i==0){
            return 0;
        }
        int energy;
        int min = Integer.MAX_VALUE;
        for(int j = 1;j <=k;j++){
            if(i-j >=0){
                if(dp[i-j] != 0){
                    energy  = dp[i-j];
                }
                else{
                    energy = energyRequired(k,i-j,heights,dp);
                }
                min = Math.min(min, (Math.abs(heights[i-j]-heights[i]))+energy);
            }
            else {
                break;
            }
        }

        return dp[i] = min;
        
    }
}

//Recursion Approach 
class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        return energyRequired(k,n-1,heights);
    }

    public int energyRequired(int k, int i,int  heights[]){
        if(i==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int j = 1;j <=k;j++){
            if(i-j >=0){
                min = Math.min(min, (Math.abs(heights[i-j]-heights[i]))+energyRequired(k,i-j,heights));
            }
            else {
                break;
            }
        }

        return min;
        
    }
}
