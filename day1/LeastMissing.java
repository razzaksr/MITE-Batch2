package day1;

public class LeastMissing {
    public static int findingMin(int[] values){
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        // find first, second min
        for(int index=0;index<values.length;index++){
            if(firstMin>values[index]){
                secondMin=firstMin;// copy current first min to second min
                firstMin = values[index];// accept new first min
            }
            else if(secondMin>values[index]&&firstMin!=values[index]){
                secondMin=values[index];
            }
        }
        System.out.println("firstMin "+firstMin);
        System.out.println("secondMin "+secondMin);
        int difference = secondMin - firstMin;
        int missing  = secondMin+1 - difference;
        if(secondMin!=missing)
            return missing;
        else{
            for(int index=0;index<values.length;index++){
                if(firstMin==values[index])
                    values[index] =  Integer.MAX_VALUE;
            }
        }
        return findingMin(values);
    }

    public static void main(String[] args) {
        int[] values = {9,8,23,8,24,78,12};
        System.out.println(findingMin(values));        
    }
}
