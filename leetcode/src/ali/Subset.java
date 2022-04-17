package ali;
import java.io.*;
import java.util.*;

public class Subset {
    private static Comparator<int[]>compare= (o1, o2) -> {
        if(o1[0]>o2[0])
            return 1;
        else if(o1[0]<o2[0])
            return -1;
        else{
            if(o1[1]>o2[1])
                return -1;
            else if(o1[1]<o2[1])
                return 1;
            else
                return 0;
        }
    };
    public static int Subset(int[]x,int[]y){
        int n=x.length;
        int[][]nums=new int[n][2];
        int len=1;
        for(int i=0;i<n;i++){
            nums[i]= new int[]{x[i], y[i]};
        }
        Arrays.sort(nums,compare);
        int[][]dp=new int[n+1][2];
        dp[1]=nums[0];
        for(int i=1;i<n;i++){
            if(dp[len][1]<nums[i][1])
                dp[++len]=nums[i];
            else if(dp[len][1]>nums[i][1]){
                int left=1,right=len,pos=0;
                while(left<=right){
                    int mid=(left+right)/2;
                    if(dp[mid][1]<nums[i][1]){
                        pos=mid;
                        left=mid+1;
                    }else
                        right=mid-1;

                }
                if(dp[pos][0]!=nums[i][0])
                    dp[pos+1]=nums[i];
            }
        }
        return len;

    }
    public static void main(String[] args) {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String str = bf.readLine();
//        int n = Integer.parseInt(str);
//        for (int i=0;i<n;i++) {
//            String str1 = bf.readLine();
//            int m = Integer.parseInt(str1);
//            String[] str2 = bf.readLine().split(" ");
//            String[] str3 = bf.readLine().split(" ");
//            int[] x = new int[m], y = new int[m];
//            for (int j = 0; j < m; j++) {
//                x[j] = Integer.parseInt(str2[j]);
//                y[j] = Integer.parseInt(str3[j]);
//            }
//            System.out.println(Subset(x, y));
//        }

//            int[][] items = new int[m][2];
//            for (int j = 0;j < m;j++){
//                items[j] = new int[]{Integer.parseInt(str2[j]),Integer.parseInt(str3[j])};
//            }
//
//            //����������
//            Arrays.sort(items,compare);
//            //res��������������еĴ�С��
//            int res = 1;
//            //��������ÿ������ĩβ��Y������С��[x,y]���顣
//            int[][] dp = new int[m + 1][2];
//            dp[1] = items[0];
//            //���ַ����в��Ҵ�ʱ��Y�ոպô�����һ���±��Y����С����һ���±��Y������������һ���±�
//            //��Y��Ϊ��ʱ��Y���Ϳ��Ա�֤dp���鱣�����ĩβ���ܵ���С��Y�����ַ��������DPѰ���
//            //���������У����죬ʱ�临�Ӷ�ΪO(nlogn)
//            for (int j = 1;j < m;j++){
//                if (dp[res][1] < items[j][1]) dp[++res] = items[j];
//                else if (dp[res][1] > items[j][1]){
//                    int l = 1,r = res,pos = 0;
//                    while (l <= r){
//                        int mid = (l + r) >> 1;
//                        if (dp[mid][1] < items[j][1]){
//                            pos = mid;
//                            l = mid + 1;
//                        }else{
//                            r = mid - 1;
//                        }
//                    }
//                    if (dp[pos][0] != items[j][0]) dp[pos + 1] = items[j];
//                }
//            }
//            System.out.println(res);
//        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int t=sc.nextInt();
            for(int k=0;k<t;k++){
                int n=sc.nextInt();
                int[]x=new int[n],y=new int[n];
                for(int i=0;i<n;i++){
                    x[i]=sc.nextInt();
                }
                for(int i=0;i<n;i++){
                    y[i]=sc.nextInt();
                }
                System.out.println(Subset(x,y));
            }

        }


        }


}
