package tim_so_lon_thu2;

public class FindSecond {
    public static void main(String[] args) {
        int[] arr = {-111, -1111, -3, -3, -5, -6};


        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }

        double second = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max) {
                if (arr[i] > second) {
                    second = arr[i];
                }
            }
        }
        System.out.println("so lon thu 2 trong mang la : "+second);
    }
}
