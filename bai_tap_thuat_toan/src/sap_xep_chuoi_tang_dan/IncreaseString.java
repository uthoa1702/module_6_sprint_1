package sap_xep_chuoi_tang_dan;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class IncreaseString {
    public static void main(String[] args) {
        String str = "asaaadtybhgf";
        String[] arr = str.split("");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        System.out.println(s);

    }
}
