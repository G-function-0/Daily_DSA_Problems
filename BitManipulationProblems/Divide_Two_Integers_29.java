//LEETCODE solution 

/*
Approach (Yo!) : 
    so we cant use / * and % right ?
        that means we can use other operators like - 
        as multiplycation is repeated addition +
        same way division is repeated subtraction 
        but we can speed up substraction by doublying and substracting 
         i.e. insted of subtracting 3 everytime we do 
            sub 3 * pow(2,i) i from 0 to 30 thats it 
         and in bit terms doubleing means left shift thats an easy guess

    PROBLEM :
     the frustating part is edge cases 
     its hard to deal with 
            if (!done) {
            dividend = dividend - (divisor << 30);
            q = q << 30;
             this thing deals with them so try to understan this by reading the code 
             its not alian but you need to read it at least once

*/

class Solution {
    public int divide(int dvd, int dvs) {
        long dividend = dvd;
        long divisor = dvs;

        boolean isNegative = false;
        if ((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0)) {
            isNegative = true;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long ans = 0;
        while (dividend >= divisor) {
            int q = 1;
            boolean done = false;

            for (int i = 0; i < 31; i++) {
                if (dividend < (divisor << i)) {
                    dividend = dividend - (divisor << (i - 1));
                    q = q << (i - 1);
                    done = true;
                    break;
                }
            }

            if (!done) {
            dividend = dividend - (divisor << 30);
            q = q << 30;
    }
            ans += q;
        }

        if (isNegative) {
            return (int) -ans;
        }
        return (int) ans;
    }
}
