package huawei;
//�������������ĺ�Ϊ����������������������֮Ϊ���������¡�����2��5��6��13��������Ӧ����ͨ�ż��ܡ���������ѧ���������һ�����򣬴����е� N �� N Ϊż����������������ѡ�����ɶ����
// ���������¡�����ѡ�������ֶ�����������4����������2��5��6��13�������5��6��Ϊһ����ֻ�ܵõ�һ�顰�������¡�������2��5��6��13���齫�õ����顰�������¡�������ɡ��������¡����ķ�����
// Ϊ����ѷ���������Ȼ����ѧ��ϣ����Ѱ�ҳ�����ѷ�������

//����:
//��һ����ż�� n ����ʾ����ѡ����Ȼ���ĸ������������ n ����������֡�
//���һ������ K ����ʾ����õġ���ѷ�������ɡ��������¡��Ķ�����
import java.util.*;
public class PrimePartners{
    static int odd_cnt=0;
    static int even_cnt=0;
    static int[]odds,evens;
    static boolean[]used;
    static int[]match;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]nums=new int[n];
        odds=new int[n];
        evens=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            if(nums[i]%2==0)
                evens[even_cnt++]=nums[i];
            else
                odds[odd_cnt++]=nums[i];
        }
        match=new int[even_cnt];
        used=new boolean[even_cnt];
        int res=0;
        Arrays.fill(match,-1);
        for(int i=0;i<odd_cnt;i++){
            Arrays.fill(used,false);
            if(find(i))
                res++;
        }
        System.out.println(res);

    }
    public static boolean isPrime(int x){
        if(x==1)
            return false;
        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

//    �������㷨
    public static boolean find(int idx){
        int odd=odds[idx];
        for(int i=0;i<even_cnt;i++){
            int even=evens[i];
            if(isPrime(even+odd)&&!used[i]){
                used[i]=true;
                if(match[i]==-1||find(match[i])){
                    match[i]=idx;
                    return true;
                }
            }
        }
        return false;
    }
}
