package day1;

import java.util.Arrays;

public class Chocolate {
    public static void main(String[] args) {
        int[] packets = {9,2,0,8,0,0,1,5,0,0,12};
        // O(n)
        int valid = 0;
        for(int current = 0;current<packets.length;current++){
            if(packets[current]!=0){
                packets[valid]=packets[current];
                valid++;
            }
        }
        Arrays.fill(packets, 5, packets.length, 0);
        System.out.println(Arrays.toString(packets));
    }
}
