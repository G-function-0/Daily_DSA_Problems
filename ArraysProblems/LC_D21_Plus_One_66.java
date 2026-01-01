//LEETCODE solution 
/*
 Approach O(n) : 
    So what problem in my intutive approach 
        the thing is i noticed but i didnt trust my intution very well i was taking care of test caes which were not thier 
        so the constrains were each index is a digit that is 0<= digit <= 9
        so on addition of 1 the digit can be <=10 not more than that right 
            and if curr digit is < 9 that means on +1 the digit will never exceed one digit limit so we directly update the digit and return the digits array as answer 
    TOTALLy understandable if you think about it.... but its hard to igest unless you dry run RIGHT?

*/
class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        for(int i =n-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] =0;
                continue;
            }
            digits[i] += 1;
            return digits;
        }
        int ans[] = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}


//INtutive  approach 
// class Solution {
//     public int[] plusOne(int[] digits) {

//         int n = digits.length;
//         int carry = 1;
        
//         for(int i =n-1;i>=0;i--){
//             if(digits[i]+carry >=9 && i!=0){
//                 int curr = digits[i] + carry;
//                 digits[i] = curr%10;
//                 carry = (curr - digits[i] )/10;
//                 continue;
//             }
//             digits[i] += carry;
//             break;
//         } 
//         if(digits[0] > 9){
//             int ans [] = new int[n+1];
//             int next = digits[0] % 10;
//             int curr = (digits[0] - next) / 10;
//             ans[0] = curr;
//             ans[1] = next;
//             for(int i=2;i < n+1; i++){
//                 ans[i] = digits[i-1];
//             }
//             return ans;
//         }
//         return digits;
//     }
// }