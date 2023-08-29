package tinh_so_lan_xuat_hien_ky_tu;

import java.util.HashMap;
import java.util.Map;

public class SoLanXuatHienCuaKyTu {
    public static void main(String[] args) {

        String s = "asdasJKHdasd";
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c)) {
                int count = characterIntegerMap.get(c);
                characterIntegerMap.put(c,count+1);
        }
            else {
                characterIntegerMap.put(c,1);
            }
        }
        for (Character c :
                characterIntegerMap.keySet()) {
            System.out.println("ky tu " + c + " xuat hien " + characterIntegerMap.get(c) + " lan");
        }
    }
}
