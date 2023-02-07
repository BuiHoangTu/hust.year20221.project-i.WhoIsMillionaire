package edu.hust.tu.projecti.util;

public class Util {
    public static String convertTime(String time){
        String result;
        String[] timeArr = time.split(" ");
        String[] date = timeArr[0].split("-");
        result = timeArr[1] + " "+ date[2]+"/"+date[1]+"/"+date[0];
        return result;
    }
}
