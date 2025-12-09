// LEETCODE solution 

/*
    Approach O(n^2):
        It is very simple think of traversing the 2d Array 
        and at each step you need to check if curr is 1 or not 
        if 1 check for his neighbours 
            for each neighbours that is 1 -> 1 wall is reduced from the preimeter 
            (you can see it in dry run or simply visualize it in a real world senario)
            now add all the walls and get the preimeter MATH MATH BLah BLah 
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int p = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int curr = grid[i][j];
                if(curr ==1){
                    int left = (j-1>=0)? grid[i][j-1] : 0;
                    int right = (j+1<col)? grid[i][j+1] : 0;
                    int up = (i-1>=0)? grid[i-1][j] : 0;
                    int down = (i+1<row)? grid[i+1][j] : 0;
                    p += (4-(left+right+up+down));
                }
            }
        }
        return p;
    }
}