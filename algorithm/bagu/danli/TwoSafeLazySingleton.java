package bagu.danli;
//单例模式中的双锁校验
public class TwoSafeLazySingleton {
    private static volatile TwoSafeLazySingleton twoSafeLazySingleton=null;
    private TwoSafeLazySingleton(){}
    public static TwoSafeLazySingleton getInstance(){
        if(twoSafeLazySingleton ==null){
            synchronized (TwoSafeLazySingleton.class){
                if(twoSafeLazySingleton==null)
                    return new TwoSafeLazySingleton();
            }
        }
        return twoSafeLazySingleton;
    }
    public void doSomething(){
        System.out.print("Do Something");
    }
}
