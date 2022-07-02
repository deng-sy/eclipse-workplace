package Nums_String;

class discountPrices {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");    // ���ݿո�ָ�ÿ������
        StringBuilder sb = new StringBuilder(); // �ַ���ƴ��
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i]; // ��ȡ��ǰ����
            if(s.matches("[$]{1}[0-9]+")) { // ������ʽ�ж��Ƿ�����Ŀ�������ҽ���1��$������1����������
                s = s.substring(1); // �޳�$����
                double d = Double.valueOf(s);   // ת��double
                d = d - d * ((double)discount / 100);   // ��ȥ�ۿ�
                strs[i] = "$" + String.format("%.2f", d);   // ����$���ţ�ȡ��λС����
            }
            sb.append(strs[i]);
            if(i < strs.length - 1) {   // �������һ������
                sb.append(" "); // ����Ӷ���ո�
            }
        }
        return sb.toString();
    }
}

