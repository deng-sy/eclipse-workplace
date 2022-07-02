package Nums_String;

class discountPrices {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");    // 根据空格分隔每个单词
        StringBuilder sb = new StringBuilder(); // 字符串拼接
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i]; // 获取当前单词
            if(s.matches("[$]{1}[0-9]+")) { // 正则表达式判断是否负责题目规则：有且仅有1个$，加上1个或多个数字
                s = s.substring(1); // 剔除$符号
                double d = Double.valueOf(s);   // 转成double
                d = d - d * ((double)discount / 100);   // 减去折扣
                strs[i] = "$" + String.format("%.2f", d);   // 加上$符号，取两位小数点
            }
            sb.append(strs[i]);
            if(i < strs.length - 1) {   // 不是最后一个单词
                sb.append(" "); // 后面加多个空格
            }
        }
        return sb.toString();
    }
}

