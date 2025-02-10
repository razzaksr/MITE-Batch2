package day3;

import java.util.Arrays;

public class MergeSortCumInversionCount {
    public static int mergeAndCountInverse(double[] src, double[] swap, int start, int mid, int end){
        int inversonCount=0;
        int leftIndex = start, rightIndex = mid+1, current = start;
        while(leftIndex<=mid&&rightIndex<=end){
            if(src[leftIndex]>=src[rightIndex]){
                swap[current]=src[rightIndex];
                rightIndex++;
                inversonCount += (mid-leftIndex+1);
            }
            else{
                swap[current]=src[leftIndex];
                leftIndex++;
            }
            current++;
        }

        while(leftIndex<=mid){
            swap[current]=src[leftIndex];
            leftIndex++;
        }
        while(rightIndex<=end){
            swap[current]=src[rightIndex];
            rightIndex++;
        }

        // replace sorted elements into orginal array
        for(int index = start; index<=end; index++){
            src[index] = swap[index];
        }

        return inversonCount;
    }
    public static int divide(double[] arr, double[] swap ,int start, int end){
        int inversion = 0;
        if(start<end){
            int mid = start+(end-start)/2;
            inversion += divide(arr, swap, start, mid);
            inversion += divide(arr, swap, mid+1, end);
            inversion += mergeAndCountInverse(arr, swap, start, mid, end);
        }
        return inversion;
    }
    public static void main(String[] args) {
        double[] arr = {2.5,9.2,4.5,19.5,2.5,56.8};
        double[] swap = new double[arr.length];
        int result = divide(arr, swap, 0,arr.length-1);
        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }
}
