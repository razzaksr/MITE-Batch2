package day8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxProfitViaPQ {
    public static void findMAx(int[] arr, int window){
        int[] result = new int[arr.length-window+1];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b)->b-a);
        for(int index = 0;index<=arr.length-window;index++){
            // System.out.println(index);
            pQueue.addAll(Arrays.asList(arr[index],arr[index+1],arr[index+2]));
            result[index]=pQueue.poll();
            pQueue.clear();
        }
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int[] stock = {120, 110, 115, 100, 105, 98, 102};
        int window = 3;
        findMAx(stock, window);
    }
}
