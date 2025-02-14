package day7;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetViaStack {

    public static int findFleet(int[] position, int[] speed, int target){
        // create indicies array
        Integer[] indicies = new Integer[position.length];
        // fill the default value 0 to 4
        for(int index=0;index<indicies.length;index++){
            indicies[index] = index;
        }
        Arrays.sort(indicies, (current,next)->position[next]-position[current]);
        // System.out.println(Arrays.toString(indicies));
        // stack where fleets going to be formed
        Stack<Double> fleets = new Stack<>();

        // iterate and check fleets can be formed or not
        for(int each:indicies){
            double time = (double)(target - position[each])/speed[each];
            // System.out.print(time+" ");
            if(fleets.isEmpty()||time>fleets.peek()){
                fleets.push(time);
            }
        }

        return fleets.size();
    }

    public static void main(String[] args) {
        int[] source = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;

        // int[] source = {3};
        // int[] speed = {3};
        // int target = 10;

        int noOfFleets = findFleet(source, speed, target);
        System.out.println(noOfFleets);
    }
}
