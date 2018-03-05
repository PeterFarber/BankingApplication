package com.peterfarber.main.core;

//Singleton
public class Validator
{

    public static boolean withinMinMax(int min, int max, String value){
        if((Double.parseDouble(value) >= min && Double.parseDouble(value) <= max)){
            return true;
        }
        return false;
    }

    public static boolean noCharacter(String value){
        for(int i = 0; i < value.length(); i++){
            if(!Character.isDigit(value.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean notNull(String value){
        if(value == null || value.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean singleLength(String value){
        if(value.length() == 1){
            return true;
        }
        return false;
    }

}
