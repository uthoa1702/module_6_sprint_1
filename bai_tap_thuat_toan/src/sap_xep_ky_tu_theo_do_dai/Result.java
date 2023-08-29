package sap_xep_ky_tu_theo_do_dai;

import java.util.Arrays;

public class Result {
    public static String sortStringWithLength(String s) {
        // Write your code here
        String[] strings = s.split(" ");
        String a = "";
        for (int i = 0; i < strings.length; i++) {
            for (int j = strings.length - 1; j > i; j--) {
                if (strings[j].length() < strings[j-1].length()){
                    String temp = strings[j];
                    strings[j] = strings[j - 1];
                    strings[j-1] = temp;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            a = a + strings[i] + " ";
        }
        return a;

    }

    public static void main(String[] args) {
        System.out.println(sortStringWithLength("akjh asdasdsf hjfg 4 htythb  aaa"));

    }
}
