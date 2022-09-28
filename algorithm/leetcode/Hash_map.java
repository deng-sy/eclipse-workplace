public class Hash_map {
    public static int tableSizeFor(int init){
//        int cap=1;
//        while(cap<init){
//            cap<<=1;
//        }
//        return cap;
        init--;
        init|=init>>>1;
        init|=init>>>2;
        init|=init>>>4;
        init|=init>>>8;
        init|=init>>>16;
        return init+1;
    }
    public static void main(String[] args) {
//        System.out.println(tableSizeFor(16));
        int i=25;
        i|=i>>>1;
        System.out.println(i);
    }
}
