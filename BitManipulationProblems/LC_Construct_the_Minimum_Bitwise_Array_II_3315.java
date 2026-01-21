//LEETCODE solution 
/*
Approach : Excatly same approach as of Q "3314 Construct bitize array 1"
     no difference cause i already provided the optimized approach 
*/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans [] = new int [n];
        for(int i=0;i<n;i++){
            int curr = nums.get(i);

            if(curr % 2 == 0){
                ans[i] = -1;
                continue;
            }

            for(int j = 1;;j++){
                if(((curr>>j)&1)  == 0 ){
                    ans[i] = curr ^ (1<<(j-1));
                    break;
                }
            }
        }

        return ans;
    }
}