package bagu.concurrent;

import java.util.*;

public class ExerciseSell {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow(2000);
        List<Thread> list = new ArrayList<>();
        // �����洢���ȥ������Ʊ
        List<Integer> sellCount = new Vector<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                // ��������ľ�̬����
                int count = ticketWindow.sell(randomAmount());
                try {
                    Thread.sleep(randomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sellCount.add(count);
            });
            list.add(t);
            t.start();
        }
        list.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // ���ȥ��Ʊ���
        System.out.printf("selled count:%d\n", sellCount.stream().mapToInt(c -> c).sum());
        // ʣ��Ʊ��
        System.out.printf("remainder count:%d", ticketWindow.getCount());
    }

    // Random Ϊ�̰߳�ȫ
    static Random random = new Random();

    // ��� 1~5
    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }
}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public synchronized int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}