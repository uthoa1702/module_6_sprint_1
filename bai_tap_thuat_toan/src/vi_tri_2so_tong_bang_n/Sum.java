package vi_tri_2so_tong_bang_n;

public class Sum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        int n = 9;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    System.out.println("vi tri "+i + " va vi tri " + j + " co tong bang " + n);
                }
            }
        }
    }
}
