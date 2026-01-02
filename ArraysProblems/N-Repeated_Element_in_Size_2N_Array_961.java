// LEETCODE solution 
/*
Approach O(n) : DIY
*/

class Solution {
    public int repeatedNTimes(int[] nums) {
    int n = nums.length;
    int i = 0;
    int arr[] = new int[10001];
    while(i < n){
        if(arr[nums[i]] == 0){
            arr[nums[i]] += 1;
            i++; 
            continue;
        }
            return nums[i];
    }
        return 0;
    }
}