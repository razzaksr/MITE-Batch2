package day4;

import java.util.Scanner;

public class SelectQuick {

    public static int findKthMost(int[] arr, int userExpected){
        int selectedIndex = arr.length-userExpected;
        return find(arr, 0, arr.length-1, selectedIndex);
    }

    public static int find(int[] arr, int start, int end, int users){
        if(start==end)
            return arr[start];
        int pivotalPoint = SortQuick.getPivotalPoint(arr, start, end);
        if(pivotalPoint==users)
            return arr[pivotalPoint];
        else if(pivotalPoint<users)
            return find(arr, pivotalPoint+1, end, users);
        else
            return find(arr, start, pivotalPoint-1, users);
    }

    public static void main(String[] args) {
        int[] arr = {14,23,7,15,20};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell us kth package from placemnet history ");
        int k = scanner.nextInt();
        System.out.println(findKthMost(arr, k));
        scanner.close();
    }
}
