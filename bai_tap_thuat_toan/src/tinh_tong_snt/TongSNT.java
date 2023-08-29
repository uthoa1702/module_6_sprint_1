package tinh_tong_snt;

import java.util.List;

public class TongSNT {
    public static void main(String[] args) {
//        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 55, 44, 22, 65, 88};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
                sum = sum + arr[i];
            }
        }
        System.out.println(sum);


    }
//    public static List<String> solve(int t, List<Integer> kArray) {
//        // Write your code here
//
//
//    }
//    public static String solve(String S) {
//        // Write your code here
//        StringBuilder str = new StringBuilder(S);
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//
//            }
//        }
//        String[] chars = S.split("");
//
//
//    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int solve(int dodai, String s) {
        // Write your code here
        int count = 0;
        for (int j = 1; j <= dodai - 1; j++) {
            if ((dodai - 1) % j == 0) {
                count++;
            }
        }
        if (count == 2) {
            return 1;
        }




        count = 0;
        for (int j = 1; j <= dodai + 1; j++) {
            if ((dodai - 1) % j == 0) {
                count++;
            }
        }



        if (count == 2) {
            return 1;
        }
        count = 0;
        for (int j = 1; j <= dodai; j++) {
            if ((dodai) % j == 0) {
                count++;
            }
        }
        if (count == 2) {
            return 1;
        }

        return 0;

    }
//    public static int solve(String S) {
//        int[] freq = new int[26];
//
//
//        for (char c : S.toCharArray()) {
//            freq[c - 'a']++;
//        }
//
//        int oddCount = 0;
//        for (int f : freq) {
//            if (f % 2 == 1) {
//                oddCount++;
//            }
//        }
//
//
//        return Math.max(0, oddCount - 1);
//    }

}

