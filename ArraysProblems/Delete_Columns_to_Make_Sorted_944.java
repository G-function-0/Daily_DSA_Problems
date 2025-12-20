//LEETCODE solution 
//Approach O(n2) : Brute force approach

class Solution {
    public int minDeletionSize(String[] strs) {
        int count =0;;
        int n = strs.length;
        for(int i =0;i<strs[0].length();i++){//for column 
            for(int j = 0;j<n-1;j++){//for row 
                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        } 
        return count;
    }
}