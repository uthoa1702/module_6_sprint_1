package hackathon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Thi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] wall = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                wall[i][j] = scanner.nextInt();
            }
        }

        int cutCount = 0;
        for (int j = 0; j < N; j++) {
            int i = 0;
            while (i < M) {
                while (i < M && wall[i][j] == 1) {
                    i++;
                }

                int start = i;
                while (i < M && wall[i][j] == 0) {
                    i++;
                }

                int end = i - 1;

                if (start <= end) {
                    cutCount++;
                }
            }
        }

        System.out.println(cutCount);

//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(-2);
//        arr.add(-3);
//        System.out.println(solve(3,8,3,arr));
//
//
//        int n = 4;
//        int k = 3;
//
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(7);
//        arr.add(2);
//        arr.add(4);
//
//        List<Integer> arr2 = new ArrayList<>();
////        278 576 496 727 410 124 338 149 209 702 282 718 771 575 436
//        arr2.add(278);
//        arr2.add(576);
//        arr2.add(496);
//        arr2.add(727);
//        arr2.add(410);
//        arr2.add(124);
//        arr2.add(338);
//        arr2.add(149);
//        arr2.add(209);
//        arr2.add(702);
//        arr2.add(282);
//        arr2.add(718);
//        arr2.add(771);
//        arr2.add(575);
//        arr2.add(436);
//     nonDivisibleSubset(7, arr2);




    }
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
//        HashSet<Integer> distinctSums2 = new HashSet<>();
//
//        HashSet<Integer> distinctSums = new HashSet<>();
//
//        for (int i = 0; i < s.size(); i++) {
//            for (int j = i + 1; j < s.size(); j++) {
//                if ((s.get(i) + s.get(j)) % k == 0  ){
//                    distinctSums.add(s.get(i) + s.get(j));
//                    distinctSums2.add(i);
//                    distinctSums2.add(j);
//                }
//            }
//        }


//
//        System.out.println(distinctSums2.size());
//        return distinctSums.size();

        int result = Math.min(1, s.get(0)); // Initialize result

        // Loop through the remainder count array
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                result += Math.max(s.get(i), s.get(k - i));
            }
        }

        // If k is even and there's at least one element with remainder k/2
        if (k % 2 == 0) {
            result++; // Include one element with remainder k/2
        }
        System.out.println(result);
        return result;
    }
    public static String solve(int n, int p, int q, List<Integer> arr) {
        // Write your code here
//        n la so nguoi tham gia
//        p la so vien soi
//        q: khong nhieu hon q thi se ket thuc tro choi
        int count  = 0;
        while (p >= q){
            for (int i = 0; i < arr.size(); i++) {
                p = p + arr.get(i);
                if (p <= q){
                    break;
                }
                count++;
            }
            if (count > 100){
                return "-1";
            }

        }

        String a = String.valueOf(count);
        return a;


    }
    public static String solve2(int n, int p, int q, List<Integer> arr) {
        // Write your code here
        if (arr.size() < 1) {
            return "0";
        }
        int count = 0;
        int b = 0;
        while (p > q) {
            p = p + arr.get(b);
            b++;
            count++;
            if (b == n) {
                b = 0;
            }
            if (count > 100000) {
                return "-1";
            }
        }
        return String.valueOf(count);

    }




}
