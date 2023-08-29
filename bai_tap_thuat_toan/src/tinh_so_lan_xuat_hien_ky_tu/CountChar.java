package tinh_so_lan_xuat_hien_ky_tu;

import java.util.Arrays;

public class CountChar {
    public static void main(String[] args) {
        String str = "asdasdasdd";


        int[] count = new int[256];

        // đếm số lần xuất hiện của mỗi ký tự trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;

        }

        // in ra số lần xuất hiện của mỗi ký tự
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println((char) i + " xuất hiện " + count[i] + " lần");
            }
        }

    }
}
