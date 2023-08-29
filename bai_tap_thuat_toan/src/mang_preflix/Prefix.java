package mang_preflix;

import java.util.ArrayList;
import java.util.List;

public class Prefix {
    public static void main(String[] args) {
        String str = "1 2 3 4 5 6";
        System.out.println(solve(str));
        ;

    }

    public static int solve(int a) {
        int total = 1;

        for (int i = 1; i <= a; i++) {
            total = total * i;
        }
        int c = total / 10;

        int b = total % 10;

        while (b == 0) {
            b = c % 10;
            c = c / 10;
        }

        return b;

    }

    public static List<Integer> solve(String s) {
        String[] strArr = s.split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum = Integer.parseInt(strArr[j]) + sum;
            }
            integerList.add(sum);
        }
        return integerList;
    }
}
