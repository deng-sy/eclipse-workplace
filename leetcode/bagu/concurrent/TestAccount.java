package bagu.concurrent;

public class TestAccount {
    public static void main(String[] args) {
//        Account2.demo(new AccountUnsafe(10000));
        Account2.demo(new AccountSafe(10000));
    }
}
