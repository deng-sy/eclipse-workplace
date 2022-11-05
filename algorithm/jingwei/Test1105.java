package jingwei;

class Print {
    boolean currentA = false;

    public synchronized void printA() {
        if (!currentA) {
            try {
                System.out.println("AAA");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentA = false;
//        System.out.println("current Thread A:" + Thread.currentThread());
        this.notify();
    }

    public synchronized void printB() {
        if (currentA) {
            try {
                System.out.println("BB");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentA = true;
//        System.out.println("current Thread B:" + Thread.currentThread());
        this.notify();
    }
}

public class Test1105 {

    public static void main(String[] args) {
        final Print p = new Print();
        int n = 2;
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                p.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                p.printB();
            }
        }).start();
    }

}

