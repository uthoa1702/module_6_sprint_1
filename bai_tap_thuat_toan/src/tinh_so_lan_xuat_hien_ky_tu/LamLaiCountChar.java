package tinh_so_lan_xuat_hien_ky_tu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LamLaiCountChar {
    public static void main(String[] args) {

//        int[] a = {1,2,3,4,5,6,7,8,9};
//        for (int i = 0; i < a.length-1; i++) {
//            for (int j = i+1; j < a.length ; j++) {
//                if (a[i] < a[j]) {
//                    int x = a[i];
//                    a[i] = a[j];
//                    a[j] = x;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 100; i++) {
            int s = (int)Math.round(12 * Math.random()) + 5;

            System.out.print(" "+s);

        }




//        Map<Character, Integer> map = new HashMap<>();
//        String str = "asdasdasd";
//        str = str.toLowerCase();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (map.containsKey(c)){
//                int count = map.get(c);
//                map.put(c,count+1);
//            }
//            else {
//                map.put(c,1);
//            }
//        }
//        for (Character c : map.keySet()) {
//            System.out.println("ky tu " + c + " xuat hien " + map.get(c) + " lan");
//        }
    }
}
