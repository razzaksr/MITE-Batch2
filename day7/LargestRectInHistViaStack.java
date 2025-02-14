package day7;

import java.util.Stack;

public class LargestRectInHistViaStack {
    public static int findRect(int[] heights){
        int maxRect = Integer.MIN_VALUE;
        Stack<Integer> myStack = new Stack<>();

        for(int index = 0;index<=heights.length;index++){
            int current = (index==heights.length)?0:heights[index];
            while(!myStack.isEmpty()&&current<heights[myStack.peek()]){
                int h = heights[myStack.pop()];
                int width = myStack.isEmpty()?index:index-myStack.peek()-1;
                maxRect = Math.max(maxRect, width*h);
            }
            myStack.push(index);
        }

        return maxRect;
    }
    public static void main(String[] args) {
        // int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 4};
        int rectangle = findRect(heights);
        System.out.println(rectangle);
    }
}
