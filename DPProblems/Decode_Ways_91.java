//Tabulation Approach :
    

//Memoized Approach

// class Solution {
//     public int numDecodings(String s) {
//         Integer dp [] = new Integer[s.length()];
//         return ways(s,0,dp);
        
//     }

//     public static int ways(String s,int i, Integer dp[]){
//         if(i==s.length()){
//             return 1;
//         }

//         if(dp[i] != null){
//             return dp[i];
//         }
//         int oneD = 0, twoD = 0; 
//         int num = (int)(s.charAt(i)-'0');
//         if(num != 0){
//             oneD += ways(s,i+1,dp); 
//         }
//         if(i<s.length()-1 && num!=0){
//             num = num*10 + (int)(s.charAt(i+1)-'0');
//             if(num <= 26){
//                 twoD +=  ways(s,i+2,dp);
//             }
//         }

//         return dp[i] = (oneD +twoD);
//     }
// }


//Recursive approach 


// class Solution {
//     public int numDecodings(String s) {
        
//         return ways(s,0);
        
//     }

//     public static int ways(String s,int i){
//         if(i==s.length()){
//             return 1;
//         }
//         int oneD = 0, twoD = 0; 
//         int num = (int)(s.charAt(i)-'0');
//         if(num != 0){
//             oneD += ways(s,i+1); 
//         }
//         if(i<s.length()-1 && num!=0){
//             num = num*10 + (int)(s.charAt(i+1)-'0');
//             if(num <= 26){
//                 twoD +=  ways(s,i+2);
//             }
//         }

//         return (oneD +twoD);
//     }
// }