package ali;
import java.util.*;

//四子棋
public class Chess {
    static char[][]board;
    static int n;
    static int m;
    public static String Chess(String[]str){
        board=new char[n][m];
        for(int i=0;i<n;i++){
            board[i]=str[i].toCharArray();
        }
        String redWin="you",purpleWin="yukari",tie="to be continued";

        int cnt_r=0,cnt_p=0;

//        从左往右
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
            }
            cnt_p=0;
            cnt_r=0;
        }
//        从上往下
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
            }
            cnt_p=0;
            cnt_r=0;
        }

//        从左上到右下
        for(int row=0;row<n;row++){
            int i=row,j=0;
            while(i<n&&j<m){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
                i++;
                j++;
            }
            cnt_p=0;
            cnt_r=0;

        }
        for(int col=1;col<m;col++){
            int i=0,j=col;
            while(i<n&&j<m){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
                i++;
                j++;
            }
            cnt_p=0;
            cnt_r=0;

        }

//        从左下到右上
        for(int row=n-1;row>=0;row--){
            int i=row,j=0;
            while(i>=0&&j<m){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
                i--;
                j++;
            }
            cnt_p=0;
            cnt_r=0;

        }
        for(int col=1;col<m;col++){
            int i=n-1,j=col;
            while(i>=0&&j<m){
                if(board[i][j]=='p'){
                    cnt_r=0;
                    cnt_p++;
                }else if(board[i][j]=='r'){
                    cnt_p=0;
                    cnt_r++;
                }else{
                    cnt_p=0;
                    cnt_r=0;
                }
                if(cnt_p==4){
                    return purpleWin;
                }
                if(cnt_r==4){
                    return redWin;
                }
                i--;
                j++;
            }
            cnt_p=0;
            cnt_r=0;

        }

        return tie;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            String[]str = new String[n];
            for(int i=0;i<n;i++){
                str[i]=sc.next();
            }
            System.out.println(Chess(str));

        }
    }
}
