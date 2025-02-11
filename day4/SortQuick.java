package day4;

import java.util.Arrays;

public class SortQuick {
    public static int getPivotalPoint(int[] arr, int start, int end){
        int init = start-1;
        int pivotalData = arr[end];

        // traversal to compare b/w pd and j, however swap b/w j and init+1
        for(int j=start;j<end;j++){
            if(arr[j]<pivotalData){
                init++;
                int temp = arr[init];
                arr[init] = arr[j];
                arr[j] = temp;
            }
        }

        // final swap to move highest value to the end, return pivotal point
        int temp = arr[end];
        arr[end] = arr[init+1];
        arr[init+1] = temp;

        return init+1;// pivotalPoint

    }

    public static void sort(int[] arr, int start, int end){
        if(start<end){
            int pivotalPoint = getPivotalPoint(arr, start, end);
            sort(arr, start, pivotalPoint-1);
            sort(arr, pivotalPoint+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {14,23,7,15,20};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
