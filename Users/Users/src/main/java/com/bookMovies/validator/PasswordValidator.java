package com.bookMovies.validator;

public class PasswordValidator {

    public static boolean passwordValidator(String password){
        int upperCase=0,lowerCase=0,number=0,specialCharacter=0;
        if(password.length()<8 || password.length()>12){
            return false;
        }
        for(int i=0;i<password.length();i++){
            if(upperCase==0 && Character.isUpperCase(password.charAt(i))){
                upperCase=1;
            }
            else if(lowerCase==0 && Character.isLowerCase(password.charAt(i))){
                lowerCase=1;
            }
            else if(number==0 && Character.isDigit(password.charAt(i))){
                number=1;
            }
            else if(specialCharacter==0 &&
                    !(Character.isLetterOrDigit(password.charAt(i)) && Character.isWhitespace(password.charAt(i)))){
                specialCharacter=1;
            }
        }

        return upperCase+lowerCase+number+specialCharacter==4;
    }
}
