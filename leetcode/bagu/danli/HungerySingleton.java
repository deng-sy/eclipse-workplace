package bagu.danli;

public class HungerySingleton {
    private static HungerySingleton instance=new HungerySingleton();
    private HungerySingleton(){}
    public static HungerySingleton getInstance(){
        return instance;
    }
    public void doSomething(){
        System.out.print("Do Something");
    }

    public static void main(String[] args) {
        HungerySingleton instance= HungerySingleton.getInstance();
        instance.doSomething();
    }
}
