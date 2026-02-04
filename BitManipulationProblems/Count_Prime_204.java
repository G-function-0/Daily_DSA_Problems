//LEETCODE solution 
/*
 Appraoch  : 
    easy application of sive of erodovsthenis (spelling is wrong)
        THats it for today
*/


class Solution {
    public int countPrimes(int n) {
        int arr [] = new int[n+1];
        int count = 0;
        for(int i = 2;i<n;i++){
            if(arr[i] == 0){
                count++;
                for(long j = (long)i*i ;j < n;j += i){
                    arr[(int)j] = 1;
                }
            }
        }

        return count;
    }
}