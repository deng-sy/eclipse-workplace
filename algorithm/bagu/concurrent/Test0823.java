package bagu.concurrent;

import static java.lang.Thread.sleep;


public class Test0823 {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {

        System.out.println("��ʼ");
        Thread t1 = new Thread(() -> {
            System.out.println("t1��ʼ");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1����");
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2��ʼ");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2����");
            r2 = 20;
        });
        t1.start();
        t2.start();
        long start=System.currentTimeMillis();
        t1.join();
        t2.join();
        long end=System.currentTimeMillis();
        System.out.println("���Ϊ:" + r1+" "+r2+" "+(end-start));
        System.out.println("����");
        ;
    }
}
