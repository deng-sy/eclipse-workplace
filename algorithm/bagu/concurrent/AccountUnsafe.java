package bagu.concurrent;

import java.util.*;

class AccountUnsafe implements Account2 {
    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        synchronized (this) {
            balance -= amount;
        }

    }
}

interface Account2 {
    // ��ȡ���
    Integer getBalance();

    // ȡ��
    void withdraw(Integer amount);

    /**
     * �����ڻ����� 1000 ���̣߳�ÿ���߳��� -10 Ԫ �Ĳ���
     * �����ʼ���Ϊ 10000 ��ô��ȷ�Ľ��Ӧ���� 0
     */
    static void demo(Account2 account) {
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end - start) / 1000_000 + " ms");
    }
}