package bagu;

public class TestE {
    public static void main(String[] args) {
        System.out.println(fun());
    }

    public static int fun() {
        int i = 10;
        try {
            i = i / 0;
            System.out.println("try");
            return --i;
        } catch (Exception e) {
            --i;
            System.out.println("catch");
            return i--;
        } finally {
            System.out.println(i);
            --i;
            System.out.println("finally");
            return i--;
        }
    }
}
