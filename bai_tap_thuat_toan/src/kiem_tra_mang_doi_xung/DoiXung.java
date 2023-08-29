package kiem_tra_mang_doi_xung;

import java.util.Scanner;

public class DoiXung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap do dai mang: ");
        int a = Integer.parseInt(scanner.nextLine());
        int[] arrr = new int[a];
        for (int i = 0; i < arrr.length; i++) {
            System.out.println("nhap so thu " + i);
            arrr[i] = Integer.parseInt(scanner.nextLine());

        }


        System.out.println(isSymmetric(arrr));
    }

    public static boolean isSymmetric(int[] arr) {
        int n = arr.length - 1;
        int count = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[n]) {
                count++;
                n--;
            }
        }
        if (count == arr.length / 2) {
            return true;
        } else {
            return false;
        }
    }
}
