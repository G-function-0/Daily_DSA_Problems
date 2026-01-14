//LEETCODE solution 

/*
Approach O(n*something) : 
    amm its not that hard if you think about it 
        so first find low high and total area first that will help later
        
        traverse a hile approx 100 times why 100? you know if you kno how binary serch works in depth 
            (Sorry cant explain right now)
        everytime you ill have 3 case 
            c1 : y > mid that is square lies above that line (skip this one)
            c2 : y < mid that is square lies below or is intersected by the line of mid
                c2.1 : y + l < mid square lies below line of mid so take the whole square 
                c2.2 : y + l > mid square is intersected -> take the part of sq that is below mid line
        

                REST you can figuer out i not spoon feeding here

*/


class Solution {
    public double separateSquares(int[][] squares) {
        double low=Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        int n = squares.length;
        double totalArea = 0;
        for(int i = 0; i < n; i++){
            if(squares[i][1] < low){
                low = squares[i][1];
            }
            if(squares[i][1] + squares[i][2] > high){
                high = squares[i][1] + squares[i][2];
            }
            totalArea += (double)squares[i][2] * squares[i][2];
        }
        int k = 1;
        while(k < 100){
            double mid = (high + low) / 2;
            double areaTillMid = 0;
            for(int i = 0; i < n; i++){
                int y = squares[i][1];
                int l = squares[i][2];
                if(y < mid){
                    if(y + l <= mid){
                        areaTillMid += (double)l * l;
                    } else {
                        areaTillMid += (mid - y) * l;
                    }
                }
            }
            if(areaTillMid >= totalArea / 2){
                high = mid;
            } else {
                low = mid;
            }
            k++;
        }
        return low;
    }
}