package day3;

public class LinearViaRecursion {
    public static int search(double[] arr, double seek, int current){
        if(current==arr.length)// when to stop recursion
            return -1;
        else{
            if(arr[current]==seek)
                return current;
            else
                return search(arr, seek, current+1);
        }
    }
    public static void main(String[] args) {
        double[] arr = {2.5,9.2,4.5,19.5,2.5,56.8};
        System.out.println(search(arr, 2.9, 0));
    }
}
