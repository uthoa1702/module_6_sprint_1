package demo_Nullpointerexception;

public class main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getId() == 1);;


        // truong hop 2
        String text1 = null;
        int length = text1.length();


        // truong hop 3
        String text2 = null;
        boolean isEmpty = text2.isEmpty(); // Gây ra NullPointerException vì `text` là null.



//         truong hop voi mang
        int[] numbers = null;
        int firstNumber = numbers[0]; // Gây ra NullPointerException vì `numbers` là null.

    }
}
