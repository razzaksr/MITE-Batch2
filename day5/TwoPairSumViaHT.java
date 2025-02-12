package day5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class TwoPairSumViaHT {

    public static List<Integer> findTwoSum(int[] arr, int target){
        Map<Integer,Integer> denom = new Hashtable<Integer,Integer>();
        List<Integer> resultList = new ArrayList<>();

        // find
        for(int index=0;index<arr.length;index++){
            int key = target - arr[index];
            int value = denom.getOrDefault(key, 0);
            if(value>0){
                resultList.add(key);
                resultList.add(arr[index]);
                break;
            }
            denom.put(arr[index], value+1);
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] transactions = {2, 7, 11, 15};
        System.out.println(findTwoSum(transactions,13));
    }
}
