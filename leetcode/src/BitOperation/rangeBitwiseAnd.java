package BitOperation;
//������������left��right����ʾ����[left,right]�����ش��������������ְ�λ��Ľ�
//��������left��right�˵㣩��
public class rangeBitwiseAnd {
    public static int rangeBitwiseAnd1(int left,int right){
        int shift=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            shift++;

        }
        return left<<shift;
    }

    public static int rangeBitwiseAnd2(int left,int right){

        while(left<right){
            right&=(right-1);

        }
        return right;
    }
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd2(5,7));
    }
}
