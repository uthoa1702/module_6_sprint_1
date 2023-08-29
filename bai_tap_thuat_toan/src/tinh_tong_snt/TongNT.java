package tinh_tong_snt;

public class TongNT {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])){
                sum = sum + arr[i];
                System.out.println("SNT : " + arr[i]);
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
