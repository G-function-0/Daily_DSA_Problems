// LEETCODE solution
/*
Approach O(n * Math.sqrt(max(nums)) :
        ok so the approach is simple i guess, this should be easiers side of MEDIUM problems so keep that mindset 
            we have used the concept that if i is divisor of N then N/i must also be divisor of N right? 
             Ex: for 21     
                1 and 21 , 3and 7 are divisors
            and the second thing the number of iteration is Math.sqrt(N) HOW?
                this is by previous knowledge and you see be DRY running also 
                    this i had learn in Math series of Striver he also gavve the proof for it
            BUT BUT BUT trust me i didnt remebered the trick i did dry run it and then it clicked oh it looks like i have seen it somewhere!
            
*/

class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        for(int i=0;i<n;i++){
            sum += giveSum(nums[i]);
        }
        return sum;
    }
    public static int giveSum(int n){
        int sq =(int)Math.sqrt(n);
        int sum =0;
        int count =0;
        for(int i =2;i<=sq;i++){

            if(n%i==0){

                sum += i;
                count++;
                if(i != n/i){
                    sum += n/i;
                    count++;
                }

            }
            if (count > 4) break;

        }
        sum += 1+ n;
        if(count==2)
            return sum; 
        return 0;  
    }
}