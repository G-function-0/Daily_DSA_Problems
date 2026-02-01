
import java.util.Arrays;

//LEETCODE solution 
// Effortless solution/Serch for a better one 

class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];
        int count = 0;
        
        Arrays.sort(nums);

        if(nums[2] != first && nums[0] != first && nums[1] != first){
           return nums[0]+nums[1]+first;
        } 

        return nums[0]+nums[1]+nums[2];
    }
}