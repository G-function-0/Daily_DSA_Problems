//LEETCODE solution 
/*
Approach : this question follows Brute force approach 
    every time we find out lowest sum pair and replace it with their sum 
    and each time e check if the list becomes soted or not 
    if it does we break out 
    Thats it 
    
*/

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>();


        for(int i =0;i<nums.length;i++){
            l.add(nums[i]);
        }

        int n = l.size();
        int count = 0;
        while(!isSorted(l)){
            int indx = -1;
            int min = Integer.MAX_VALUE;
            for(int i =0; i < l.size()-1;i++){
                int curr = l.get(i) + l.get(i+1);
                if(curr < min){
                    min = curr;
                    indx = i;
                }
            }

            l.remove(indx+1);
            l.set(indx,min);
            count++;
        }

        return count;
    }

    public static boolean isSorted(List<Integer> l){

        int n = l.size();
        for(int i =0;i<n-1;i++){
            if(l.get(i) > l.get(i+1))
                return false;
        }

        return true;
    } 
}