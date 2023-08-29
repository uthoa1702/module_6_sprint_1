package sum_uoc_chung;

import java.util.ArrayList;
import java.util.List;

public class UocChung {
    public static void main(String[] args) {

        List<Integer> list1 = checkUoc(20);
        List<Integer> list2 = checkUoc(30);
        System.out.println(list1);
        System.out.println(list2);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {

                }
            }
        }

    }

    public static List<Integer> checkUoc(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
