package day5;

import java.util.Hashtable;
import java.util.Map;

public class FindFreqViaHT {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,1};

        // Hashtable<Integer,Integer> frequncyTable = new Hashtable<>();
        Map<Integer,Integer> frequncyTable = new Hashtable<>();// factory pattern

        for(int index = 0;index<arr.length;index++){
            int currentElement = arr[index];
            int currentValue = frequncyTable.getOrDefault(currentElement, 0);
            frequncyTable.put(currentElement, currentValue+1);
        }

        System.out.println(frequncyTable);
    }
}
