//LEETCODE solution 
/*
Approach O(n+nlogn) :
    Sort the array and use two pointers one at the bigining and other at the end and find the maximum sum possible 
    Simple and straight forward
*/


import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i =0;i<n/2;i++){
            int sum = nums[i] + nums[n-1-i];
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}