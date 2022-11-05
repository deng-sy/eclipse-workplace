package yizhifu;

class Father {
    String name;

    public static void static_method() {
        System.out.println("static method of father");
    }

    public Father() {
        this.name = "father";
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
        this.name = "son";
        System.out.println("son");
    }

    public void method() {
        System.out.println("method of son");
    }
}

public class Test {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.name);
        father.static_method();
    }
}
