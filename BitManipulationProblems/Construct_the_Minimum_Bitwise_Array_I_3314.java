// LeetCode Solution
/*
Approach (Yo!) :
    think like this (extra info)
        what does this operation does (n | n+1) ?
            this operation is very famous and this sets the RIGHT MOST Bit in numebr n 
                    THAT was the key 

        so our job is to find a number 'n' of which we set the right most zero and it becomes (Lets say) 'm'

        so for a evven number their exits no "n" read the above statement you will understand this 

        if a number is odd then we do reverse engineering and find n  from m 
            what we do -> their are a set of trailing 1's right? flip MSB of this trailing block and yeah we get 'n' and store it in answer array 
        THats what i did read the code 
         
*/


class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int ans[] = new int [n];

        for(int i =0;i<n;i++){
            int curr = nums.get(i);
                if(curr % 2 == 0){
                    ans[i] = -1;
                    continue;
                }
                

                for(int j =1;;j++){
                    if(((curr >> j) & 1) == 0){
                        ans[i] = curr ^ (1<<(j-1));
                        break;
                    }
                }
            }
        

        return ans;
    }
}