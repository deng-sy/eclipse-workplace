package bagu.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

class AccountSafe implements Account2 {
    private AtomicInteger balance;

    public AccountSafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
        // ���Լ�Ϊ����ķ���
        // balance.addAndGet(-1 * amount);
    }
}