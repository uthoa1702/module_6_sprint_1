package ve_hinh_thoi;

import java.util.Scanner;

public class HinhThoi {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập chiều cao của hình thoi: ");
//        int height = scanner.nextInt();
//
////        // Vẽ phần trên hình thoi
//        for (int i = 1; i <= height; i++) {
//            for (int j = 1; j <= height - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i -1 ; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        for (int i = height - 1; i >= 1 ; i--) {
//            for (int j = 1; j <= height - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i -1 ; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }












//        for (int i = 1; i <= height; i++) {
//            for (int j = 1; j <= height - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        // Vẽ phần dưới hình thoi
//        for (int i = height - 1; i >= 1; i--) {
//            for (int j = 1; j <= height - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều cao của hình thoi (số lẻ): ");
        int height = scanner.nextInt();

        if (height % 2 == 0) {
            System.out.println("Chiều cao cần là một số lẻ.");
            return;
        }

        int space = height / 2;

        // Vẽ phần trên hình thoi
        for (int i = 1; i <= height; i += 2) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            space--;
        }

        space = 1;

        // Vẽ phần dưới hình thoi
        for (int i = height - 2; i >= 1; i -= 2) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            space++;
        }

    }
}
