package day2;

import java.util.Arrays;

// Find max sub array
public class MaxBalance {
    public static int findMax(int[] arr, int start, int end){
        if(start==end)
            return arr[start];
        int mid = start+(end-start)/2;
        int leftMax = findMax(arr, start, mid);
        int rightMax = findMax(arr, mid+1, end);
        int crossMax = findCross(arr, start, mid, end);
        System.out.println(leftMax+" "+crossMax+" "+rightMax+" max is "+(Math.max(Math.max(leftMax, rightMax), crossMax)));
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    public static int findCross(int[] arr, int start, int mid, int end){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int index = mid;index>=start;index--){
            currentSum+=arr[index];
            if(currentSum>leftSum){
                leftSum=currentSum;
            }
        }
        currentSum=0;
        for(int index = mid+1;index<=end;index++){
            currentSum+=arr[index];
            if(currentSum>rightSum){
                rightSum=currentSum;
            }
        }
        return leftSum+rightSum;
    }
    public static void main(String[] args) {
        // int[] balances = {2, -4, 1, 9, -6, 7, -3};
        int[] balances = {-2, 1, 3, -3, 4, -1, 2, 1, -5, 4};
        // int[] balances = {1,9,6,4,5};
        System.out.println(findMax(balances, 0, balances.length-1));
    }
}
