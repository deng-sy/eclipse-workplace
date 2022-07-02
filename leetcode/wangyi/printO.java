package wangyi;

import java.util.*;
public class printO {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int cnt=n;
            for(int i=0;i<2*n;i++){
                if(cnt==0){
                    for(int j=0;j<4*n;j++){
                        if((j>=0&&j<n)||(j>=4*n-n&&j<4*n)){
                            System.out.print('*');
                        }else{
                            System.out.print('.');
                        }
                    }
                }else{
                    for(int j=0;j<4*n;j++){
                        if((j>=0&&j<cnt)||(j>=4*n-cnt&&j<4*n)){
                            System.out.print('.');
                        }else{
                            System.out.print('*');
                        }
                    }
                    cnt--;
                }


                System.out.println();
            }
            cnt=1;
            int idx=n;
            for(int i=0;i<2*n;i++){
                if(idx>0){
                    for(int j=0;j<4*n;j++){
                        if((j>=0&&j<n)||(j>=4*n-n&&j<4*n)){
                            System.out.print('*');
                        }else{
                            System.out.print('.');
                        }
                    }
                    idx--;
                }else{
                    for(int j=0;j<4*n;j++){
                        if((j>=0&&j<cnt)||(j>=4*n-cnt&&j<4*n)){
                            System.out.print('.');
                        }else{
                            System.out.print('*');
                        }
                    }
                    cnt++;
                }

                System.out.println();
            }
        }
    }
}
