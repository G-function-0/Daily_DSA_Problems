// Questions writting is very bad dont solve this one 

class Solution {
    public int minDeletionSize(String[] strs) {
        int col = strs[0].length();
        int n = strs.length;
        int ans = 0;

        boolean decided[] = new boolean[n];

        for (int i = 0; i < col; i++) {
            boolean deleteCol = false;

            //checking if this column must be deleted
            for (int j = 1; j < n; j++) {
                if (!decided[j - 1] &&
                    strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    ans++;
                    deleteCol = true;
                    break;
                }
            }

            // if deleted, we will not update decided[]
            if (deleteCol) continue;

            // now update decided pairs
            for (int j = 1; j < n; j++) {
                if (!decided[j - 1] &&
                    strs[j - 1].charAt(i) < strs[j].charAt(i)) {
                    decided[j - 1] = true;
                }
            }
        }
        return ans;
    }
}






// class Solution {
//     public int minDeletionSize(String[] strs) {
//         int col = strs[0].length();
//         int n = strs.length;
//         int ans = 0;
//         int nextComp =0;
//         boolean end = false;
//         for(int i=0;i<col && !end;i++){
//             for(int j=nextComp;j<n-1;j++){
//                 if(strs[j].charAt(i) > strs[j+1].charAt(i)){
//                     ans++;
//                     nextComp = j;
//                     break;
//                 }
//                 if(strs[j].charAt(i) == strs[j+1].charAt(i)){
//                     nextComp = j;
//                     break;
//                 }
//                 if(j == n-2){
//                     end = true;
//                 }
//             }
//         }

//         return ans;
//     }
// }