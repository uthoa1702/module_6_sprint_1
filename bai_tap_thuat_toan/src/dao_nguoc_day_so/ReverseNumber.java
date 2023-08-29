package dao_nguoc_day_so;

import java.util.Arrays;
import java.util.Scanner;

public  class ReverseNumber {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int temp;
        int n = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            n--;
        }
//        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseInteger(arr1)));
    }

    public static int[] reverseInteger(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

}
