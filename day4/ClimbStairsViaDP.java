package day4;

import java.util.Scanner;

public class ClimbStairsViaDP {
    public static int find(int steps){
        if(steps==0)
            return 0;
        int[] poss = new int[steps+1];// 9>> 0-8
        poss[0]=0;poss[1]=1;poss[2]=2;
        // perform 
        for(int index = 3; index <= steps; index++){
            poss[index] = poss[index-1]+poss[index-2];
        }

        return poss[steps];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell us the stair case count ");
        int total = scanner.nextInt();// 8
        System.out.println(find(total));

        scanner.close();
    }
}
