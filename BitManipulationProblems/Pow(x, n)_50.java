//LEETCODE solution

/*
Appraoch (Yo!):
    nah it very similar to normal Pow(x,n);
        just with some negatie numbers and one edge case 
    THats it! Squeeze rest of the lemon 
        
*/

class Solution {
    public double myPow(double x, int N) {
        long n =N;
        boolean isNegative = false;
        if(n < 0){
            n = Math.abs(n);
            isNegative = true;
        }

        double ans = 1; 
        while(n>0){
            int bit = (int) n & 1;
            if(bit == 1){
                ans *= x; 
            }
            x *= x;
            n = n>>1;
        }

        if(isNegative) {
            ans = 1/ans;
        }

        return ans;
    }
}