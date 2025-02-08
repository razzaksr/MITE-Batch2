package day2;

import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initialize the Game ");
        String board = scanner.next();
        int move = 0;

        for(int index=0;index<board.length();){
            if(board.charAt(index)=='X'||board.charAt(index)=='x'){
                move++;
                index+=3;// non linear
            }
            else    
                index++; // linear
        }
        System.out.println("Required move are "+move);
        scanner.close();
    }
}
