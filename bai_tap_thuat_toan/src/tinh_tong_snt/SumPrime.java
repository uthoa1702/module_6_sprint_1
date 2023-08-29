package tinh_tong_snt;

import java.util.Arrays;

public class SumPrime {
    public static void main(String[] args) {
        int[] arr = {2, 3,4, 1, 6, 7, 9, 55, 13};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
                sum = sum + arr[i];
            }
        }

        System.out.println("Tổng các số nguyên tố trong mảng là: " + sum);
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
