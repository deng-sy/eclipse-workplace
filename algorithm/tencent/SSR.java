package tencent;
//小A在玩一个网络游戏。这个游戏有个抽装备环节。装备池总共有n+m件装备，分别为n件普通装备和m件ssr装备。抽一次装备的费用按你抽中的装备决定。
//抽中每一件装备的概率都为1/(n+m)。如果你抽中了ssr装备。这次的抽装备费用为2金币，否则这次的费用为1金币。如果你抽中了ssr装备，得到奖励，
// 并且装备不会放回。如果你抽中了普通装备。得到奖励，但是这件装备会放回装备池。现在小A希望抽中所有的ssr装备，请你计算一下：需要花费金币的期望值。
public class SSR {
    public static double SSR(int n,int m){
        double expectation=0.2f;
        return expectation;
    }

    public static void main(String[] args) {
        System.out.print(SSR(2,1));
    }
}
