package day4;

import java.util.Arrays;

public class WordConversionViaDP {

    public static int findPoss(String src, String dest){
        if(src.length()==0||dest.length()==0)
            return 0;
        int rowSize = src.length();
        int colSize = dest.length();
        int[][] poss = new int[rowSize+1][colSize+1];

        // fill the default value in the 0th row
        for(int col = 0; col<= colSize; col++){poss[0][col] = col;}

        // fill the default value in 0th column of all rows
        for(int row=0;row<=rowSize;row++){poss[row][0]=row;}

        // for(int[] row:poss){System.out.println(Arrays.toString(row));}

        // compare and fill based on two rule
        for(int row=1;row<=rowSize;row++){
            for(int col=1;col<=colSize;col++){
                // check the character
                if(src.charAt(row-1)==dest.charAt(col-1))
                    poss[row][col]=poss[row-1][col-1];
                else{
                    // min between left,right, diagonal
                    poss[row][col]=1+Math.min(poss[row][col-1], 
                    Math.min(poss[row-1][col-1], poss[row-1][col])
                    );
                }
            }
        }

        return poss[src.length()][dest.length()];
    }

    public static void main(String[] args) {
        String source = "horse";
        String dest = "rose";
        System.out.println(findPoss(source, dest));
    }
}
