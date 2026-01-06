//LEETCODE
/*
    Approach O(n^2) : 
        simple thier can be to case 
            total number of negative numbers are 
                even : 
                    then its natural if you dry run it eventually all the negative numbers become positive 
                
                odd :
                    then we can reduce number of negative numbers to 1 and
                         for maximizeing this sum we make minimum number to be that -iv number 
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        int min = Integer.MAX_VALUE;
        int negatives =0;
        long sum =0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                int curr = matrix[i][j];
                sum += Math.abs(curr);
                if(curr < 0){
                    negatives++;
                }

                if(min > Math.abs(curr)){
                    min = Math.abs(curr);
                }
            }
        }

        if(negatives%2 == 0){
            return sum;
        }

        sum -= (2*Math.abs(min));
        return sum;
    }
}