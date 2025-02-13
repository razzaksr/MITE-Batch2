package day5;

import java.util.ArrayList;
import java.util.List;

// Sliding window to find max sum of sub array

public class FindMaxSumSubViaSW {

    public static List<Integer> findSubSum(int[] arr, int window){
        List<Integer> foundElements = new ArrayList<>();
        int maxSum = 0;
        int currentSum = 0;

        // initializing elements with first window size from array
        for(int index = 0; index<window; index++){
            currentSum += arr[index];
        }
        maxSum = currentSum;
        int index, start=0;
        for(index = window; index<arr.length;index++){
            currentSum += arr[index] - arr[index-window];
            // maxSum = Math.max(maxSum, currentSum);
            if(currentSum>=maxSum){
                maxSum = currentSum;
                start = index- window+1;
            }
        }
        System.out.println("Max Sum "+maxSum);
        
        for(index = 0;index<window;index++){
            foundElements.add(arr[start+index]);
        }

        return foundElements;
    }

    public static void main(String[] args) {
        int[] transactions = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int windowSize = 3;
        System.out.println(findSubSum(transactions, windowSize));
    }
}
