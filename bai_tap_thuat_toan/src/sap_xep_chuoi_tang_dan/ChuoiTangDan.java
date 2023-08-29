package sap_xep_chuoi_tang_dan;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ChuoiTangDan {
    public static void main(String[] args) {
        String a = "asdf    asd";
        sortString(a);

    }

    public static void sortString(String str) {

    }

    public void sortString(String str, Integer abc) {
        str = str.trim();
        str = str.toLowerCase();
        char[] arr =   str.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
    }

    public String sortString(String str, String abc
    ) {
        return this.sortString(str, abc, 1L);

    }

    public String sortString(String str, String abc, Long id
    ) {
        str = str.trim();
        str = str.toLowerCase();
        char[] arr =   str.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
        return null;

    }
}
