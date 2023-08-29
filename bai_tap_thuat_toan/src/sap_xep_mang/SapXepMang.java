package sap_xep_mang;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SapXepMang {
    public static void main(String[] args) {
        int[] arr = {4,2,1,2,3};
        System.out.println(Arrays.toString(desc(arr)));
    }

    public static int[] asc(int[] arr){
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] desc(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
