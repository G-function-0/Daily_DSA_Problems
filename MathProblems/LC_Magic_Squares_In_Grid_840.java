// LEETCODE Solution 
/*
APproach O(nxmx9) : 
    so its not that difficult question 
    i can solve this in n*m*9 time complexity 
    fist i will traverse each element in the matrix and consider that element to be the starting point of my 3*3 grid 
    next i will check if all the rows, columns and diagonal in this 3x3 grid are summing up to 15 or not if not i will not increase the count and move on 
    i know thier cant be a answer greater than 4 cause of the fact that 5 must be in the center and all the even numbers belong that in the corner and odd numbers belong in the middle in some particular oredr only yeah this was mhy soltion TRUST ME THIS IS A FACT I CAME ACCROSS THIS IN DISSCUSSSIONS but you should dry run to belive this 
*/


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;

        for(int i =0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                Set<Integer> s = new HashSet<>();

                //pruning 
                if(grid[i+1][j+1] != 5){
                    continue;
                }
                int c1 = 0, r1 =0, c2 =0, r2= 0, c3 = 0, r3 =0, dia = 0;
                boolean exit = false;
                for(int k = 1; k <= 3 && !exit;k++){
                    for(int g = 1;g <= 3;g++){
                        int curr = grid[i+k-1][j+g-1];
                        if(k==1){
                            r1 += curr;
                        }
                        if(k==2){
                            r2 += curr;
                        }
                        if(k==3){
                            r3 += curr;
                        }
                        if(g==1){
                            c1 += curr;
                        }
                        if(g==2){
                            c2 += curr;
                        }
                        if(g==3){
                            c3 += curr; 
                        }
                        if(g==k){
                            dia += curr;
                        }
                        if(s.contains(curr) || curr == 0){
                            exit = true;
                            break;
                        }
                        s.add(curr);
                    }
                }

                //check 

                if(r1 == 15 && r2 == 15 && r3 == 15 && c1 == 15 && c2 == 15 && c3 == 15 && dia == 15 ){
                    count++;
                }

            }
        }

        return count;
        
    }
}