//LEETCODE solution 
/*
Approach:
    i know the dp appraoch is intutive its simple and straight 
        we need to check when do we get the max value do we get it by includeing the current element or by excluding it 
        when we include current we need to do i+2 to ignore the next ele
            else we exclude current and move to next i.e. i+1
        simple maintian dp array and do this 

Space Optimized Approach : 
    if we see carefully the answer only depends on max out of to values 
        either we include curr ele and include ans of subarray before prev
            or we include ans of prev and exclude current ele 
                EX: [{1,2},3,{4},5,6]  include i==3
                    [{1,2,3},4,5,6]  exclude i==3
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int robBeforePrev = 0;
        int robPrev = 0;
        for(int i =0;i<n;i++){
            int temp  = Math.max(robBeforePrev+nums[i],robPrev);
            robBeforePrev =robPrev;
            robPrev = temp;
        }
        return robPrev;
    }
}
