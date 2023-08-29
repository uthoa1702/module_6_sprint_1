package dem_so_len_xuat_hien_cua_phan_tu;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        String str = "truong quoc HOOoa";
       countChar(str);



    }
    public static void countChar(String str){
        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c)){
                int count = map.get(c) + 1;
                map.put(c, count);
            }
            else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> a : map.entrySet()) {
            System.out.println(a.getKey() + " xuat hien " + a.getValue());
        }
    }

}
