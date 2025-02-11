package day4;

import java.util.Scanner;

public class FactorialViaDP {
    public static int find(int number){
        if(number==0)
            return 1;
        int[] poss = new int[number+1];
        poss[0]=1;
        for(int index=1;index<=number;index++){
            poss[index] = index * poss[index-1];
        }
        return poss[number];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell us the number to find factorial ");
        int total = scanner.nextInt();// 8
        System.out.println(find(total));

        scanner.close();
    }
}
