import java.time.LocalDate;


public class demo {
    public static void main(String[] args) {
        String a = "2023-07-20";
        LocalDate s = LocalDate.now();
        System.out.println(s);
        if ( a == String.valueOf(s)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}
