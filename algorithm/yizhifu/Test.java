package yizhifu;

class Father {
    public static void static_method() {
        System.out.println("static method of father");
    }

    public Father() {
        System.out.println("father");
    }

    public void method() {
        System.out.println("method of father");
    }
}

class Son extends Father {
    public static void static_method() {
        System.out.println("static method of son");
    }

    public Son() {
        System.out.println("son");
    }

    public void method() {
        System.out.println("method of son");
    }
}

public class Test {
    public static void main(String[] args) {
        Father father = new Son();
        father.static_method();
    }
}
