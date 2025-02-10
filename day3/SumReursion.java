package day3;

public class SumReursion {

    public static double findSum(double[] arr, int start, double sum){
        if(start==arr.length)
            return sum;
        else{
            sum+=arr[start];
            return findSum(arr, start+1, sum);
        }
    }

    public static void main(String[] args) {
        // int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        double[] arr = {2.5,9.2,4.5,19.5,2.5,56.8};
        System.out.println(findSum(arr, 0, 0));
    }
}
