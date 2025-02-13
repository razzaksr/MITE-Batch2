package day6;

import java.util.Arrays;
import java.util.Stack;

public class TemperatureViaStack {
    public static int[] findWarm(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> myStack = new Stack<>();

        for(int index = 0;index<arr.length;index++){
            // find temp day count
            while(!myStack.isEmpty()&&arr[myStack.peek()]<=arr[index]){
                int got = myStack.pop();
                result[got] = index-got;
            }
            myStack.push(index);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] received = findWarm(temp);
        System.out.println(Arrays.toString(received));
    }
}
