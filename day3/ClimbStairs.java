package day3;

public class ClimbStairs {
    public static int possible(int staircase){
        if(staircase==0)
            return 0;
        else if(staircase==1)
            return 1;
        else if(staircase==2)
            return 2;
        else
            return possible(staircase-1)+possible(staircase-2);
    }
    public static void main(String[] args) {
        System.out.println(possible(8));
    }
}
