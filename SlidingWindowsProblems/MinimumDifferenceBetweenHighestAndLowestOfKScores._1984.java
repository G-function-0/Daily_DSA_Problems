//LEETCODE solution 
/*
Approch O(n+nlogn):
    sort the array and use sildig indows from last of K length.
*/


class Solution {
    public int minimumDifference(int[] nums, int k) {
        // sort nums array 
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = n-1;(i-k+1)>=0;i--){
            int currDiff = nums[i] - nums[i-k+1];
            if(currDiff < ans) ans = currDiff;
        }

        return ans;
    }
}