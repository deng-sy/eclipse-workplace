package bagu.concurrent;
//按序打印

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

//原子类
class Foo1 {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo1() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }


}

//sychronised
class Foo2 {

    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();

    public Foo2() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

//信号量
class Foo3 {

    Semaphore s12 = new Semaphore(0);
    Semaphore s23 = new Semaphore(0);

    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s12.release();//释放后s12的值会变成1
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s12.acquire();//没有会阻塞  当为1的时候，说明线程2可以拿到s12了
        printSecond.run();
        s23.release();//释放后s23的值会变成1
    }

    public void third(Runnable printThird) throws InterruptedException {
        s23.acquire();//0的时候拿不到，1的时候可以拿到
        printThird.run();
    }
}


class Foo4 {
    CountDownLatch latch12 = new CountDownLatch(1);
    CountDownLatch latch23 = new CountDownLatch(1);

    public Foo4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        latch12.countDown();//唤醒线程2
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch12.await();//latch12的值为0会执行下面的语句，否则会在此次阻塞
        printSecond.run();
        latch23.countDown();//准备唤醒线程3
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch23.await();//latch23的值为0会执行下面的语句，否则会在此次阻塞
        printThird.run();
    }
}


//同步队列,没有容量，进去一个元素，必须等待取出来以后，才能再往里面放一个元素
class Foo5 {
    BlockingQueue<Integer> block12 = new SynchronousQueue<>();
    BlockingQueue<Integer> block23 = new SynchronousQueue<>();

    public Foo5() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        block12.put(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        block12.take();//
        printSecond.run();
        block23.put(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        block23.take();
        printThird.run();
    }
}

public class Foo {
    public static void main(String[] args) {
        Foo2 foo = new Foo2();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}