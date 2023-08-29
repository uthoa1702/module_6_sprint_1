package trung_vi_2_mang;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TrungVi2mang {
    public static void main(String[] args) {
        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(1);
        integerList1.add(2);
        integerList1.add(3);
        integerList1.add(4);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);
        integerList2.add(4);
        System.out.println(solve(integerList1,4,integerList2, 4));

    }
    public static String solve(List<Integer> arr1, int m, List<Integer> arr2, int n) {
        if (m+n < 1){
            return "0.00000";
        }
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        for (int i = 0; i < arr1.size(); i++) {
            integerTreeSet.add(arr1.get(i));
        }
        for (int i = 0; i < arr2.size(); i++) {
            integerTreeSet.add(arr2.get(i));
        }
        int a = integerTreeSet.size() % 2;
        List<Integer> integerList = new ArrayList<>();
        for (Integer e :
                integerTreeSet) {
            integerList.add(e);
        }
        int c = integerList.size() / 2;
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");

        if (a == 0){
            Double b = (Double.valueOf(integerList.get(c - 1) + integerList.get(c))) / 2;


            return decimalFormat.format(b);
        }
        else {
            Double b = Double.valueOf(integerList.get(integerList.size() / 2));
            return decimalFormat.format(b);

        }
    }
}
