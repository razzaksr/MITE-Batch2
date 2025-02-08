package day2;

import java.util.Arrays;

public class EquilibriumDay {
    public static void main(String[] args) {
        int[] myStatement = {-7, 1, 5, 2, -4, 3, 0};
        // int[] myStatement = {10, 20, 30, 10, 10, 10, 30, 20, 10, 10};
        int totalSum = Arrays.stream(myStatement).sum();
        int leftSum = 0;
        System.out.println(totalSum);
        for(int index = 0;index<myStatement.length;index++){
            totalSum -= myStatement[index];
            System.out.println(totalSum+" "+leftSum);
            if(totalSum==leftSum){
                System.out.println("EquilibriumDay is "+index);
                break;
            }
            leftSum += myStatement[index];
        }
    }
}
