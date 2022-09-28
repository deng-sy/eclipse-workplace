package bagu;

import java.util.Date;

public class Test extends Date {
    private static int x=1;
    public static void main(String[] args) {
        Test.test();
        System.out.println(Test.x);
    }

    static int test() {

        try {
            return x;
        } finally {
            x++;
        }
    }
}
