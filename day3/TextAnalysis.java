package day3;

import java.util.regex.Pattern;

public class TextAnalysis {
    public static void find(String text, int countVow, int countCon, int index){
        if(index==text.length()){
            System.out.println("Vowels: "+countVow);
            System.out.println("Consonents: "+countCon);
        }
        else{
            if(text.charAt(index)=='a'||text.charAt(index)=='e'||text.charAt(index)=='i'||text.charAt(index)=='o'||text.charAt(index)=='u')
                countVow++;
            else if(!Pattern.matches("^[@ ,.;:!']$", text.substring(index, index+1)))
                countCon++;
            find(text, countVow, countCon, index+1);
        }
    }
    public static void main(String[] args) {
        String myText = "Hello, AI!";
        myText=myText.toLowerCase();
        find(myText, 0, 0, 0);
    }
}
