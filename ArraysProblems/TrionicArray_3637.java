//LEETCODe solution 

/*
Approach  O(n) : {
    ok the solution is prety much simple 
    we will do this with elemination methon as tought in Permutation and Conbination (CLass 9 th Stuff) 
    simple we know the valide states but lets return false on all the invalide states then the problem is solved 

    c1 : repeated elements  -> curr == next return false 
    c2 : non increasing from the start  i.e. from 0 to p -> p ==-1 and q == -1 then array must be increasing  else return false 
    c3 : non decreasing in the middle i.e. from p to q -> p > -1 and q == -1 then array must be decreasing else return false
    c4 : last but not the least 0 < p < q < n − 1  --> i.e. p==0 || p == q || q == -1  why q==-1 will return false is hard to understand but try DRy run you will understand 

    at last return true;
}
 */
class Solution {

    public boolean isTrionic(int[] nums) {
        //strictly decreasing or increasing -->> edgecase 

        int n = nums.length;
        int p = -1, q = -1;
        for (int i = 0; i < n - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (curr > next && p == -1) {
                p = i;
            }
            if (curr < next && p != -1 && q == -1) {
                q = i;
            }
            if (curr == next) {
                return false;
            }
            if (p > -1 && q == -1 && curr < next) {
                return false;
            }
            if (((p > -1 && q > -1) || (p == -1 && q == -1)) && curr > next) {
                return false;
            }

        }
        if (p == 0 || p == q || q == -1) {
            return false;
        }
        return true;
    }
}
