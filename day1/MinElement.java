package day1;
public class MinElement{
    public static void main(String[] args) {
        int[] values = {9,5,23,67,24,78,12};
        int minimum = values[0];
        // find min
        for(int position=0;position<values.length;position++){
            if(minimum > values[position])
                minimum = values[position];
        }
        System.out.println("minimum is "+minimum);
    }
}