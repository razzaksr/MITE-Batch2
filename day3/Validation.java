package day3;

import java.util.regex.Pattern;

public class Validation {
    public static void main(String[] args) {
        String namePattern = "^[A-Za-z ]{3,}$";
        String passwordPattern = "^[A-Z0-9a-z@$]{8,}$";
        String aadhaarPattern = "^[0-9]{12}$";
        String myName = "Raz";
        String myPass = "razak$123";
        String myAadhaar = "765456787912";
        System.out.println(Pattern.matches(namePattern, myName));
        System.out.println(Pattern.matches(passwordPattern,myPass));
        System.out.println(Pattern.matches(aadhaarPattern, myAadhaar));
    }
}
