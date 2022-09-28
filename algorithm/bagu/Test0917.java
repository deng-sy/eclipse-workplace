package bagu;


class Father {
    public Father() {
        System.out.println("father");
    }
}

class Son extends Father {
    public Son() {
        System.out.println("son");
    }
}

public class Test0917 {
    public static void main(String[] args) {
        Father son = new Son();
        Integer x = 1000, y = 1000;
        System.out.println(x == y);
        System.out.println(son.getClass());
        System.out.println(1 / 0);


    }
}
