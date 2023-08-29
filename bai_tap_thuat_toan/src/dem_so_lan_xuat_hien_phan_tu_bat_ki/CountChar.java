package dem_so_lan_xuat_hien_phan_tu_bat_ki;

import java.util.*;

public class CountChar {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String str = "asdasdasdaaa";
        str = str.toLowerCase();
        String c;

        for (int i = 0; i < str.length(); i++) {
            c = String.valueOf(str.charAt(i));
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c,count+1);
            }else {
                map.put(c,1);
            }
        }
        System.out.println("nhap ky tu bat ky" );
        String b = scanner.nextLine();
        for (String a: map.keySet()) {
            if (Objects.equals(b, a)) {
                System.out.println("ky tu " + a+ " xuat hien " + map.get(a)+ " lan");
            }

        }
    }
}
