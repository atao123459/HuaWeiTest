import java.util.*;

/*
2022.7.12

已知火星人使用的[运算符]为#、$，

其与地球人的等价公式如下：

x#y = 2x+3y+4
x$y = 3*x+y+2

其中x、y是无符号整数

地球人公式按C语言规则计算，火星人公式中，$的[优先级]高于#，相同的运算符，按从左到右的顺序计算
现有一段火星人的字符串报文，请你来翻译并计算结果。

**输入描述：**

火星人字符串[表达式]（结尾不带回车换行）

**输入的字符串说明：**

字符串为仅由无符号整数和操作符（#、$）

组成的计算表达式。例如：123#45#6778

用例保证字符串中，操作数与操作符之间没有任何分隔符。
用例保证操作数取值范围为32位无符号整数。
保证输入以及计算结果不会出现整型溢出。
保证输入的字符串为合法的求值报文，例如：123#45#6778
保证不会出现非法的求值报文，例如类似这样字符串：
#4$5 //缺少操作数
4$5# //缺少操作数
4#$5 //缺少操作数
4 $5 //有空格
3+4-5*6/7 //有其它操作符
12345678987654321$54321 //32位整数计算溢出

**输出描述：**

根据输入的火星人字符串输出计算结果（结尾不带回车换行）
 */
public class Mars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        if(content.contains(" ") || content.contains("+") || content.contains("-") || content.contains("*") || content.contains("/")){
            return;
        }
        if(content.charAt(0) == '#' || content.charAt(0) == '$'){
            return;
        }
        if(content.charAt(content.length() - 1) == '#' || content.charAt(content.length() - 1) == '$'){
            return;
        }
        System.out.println(count(content));
    }

    public static int count(String content){
        int index;
        index = content.lastIndexOf("#");//获取对应操作符所在位置
        if(index != -1){
            String left = content.substring(0,index);//获取左边的内容
            String right = content.substring(index + 1);//获取右边内容
            return 2 * count(left) + 3 * count(right) + 4;//递归计算结果
        }
        index = content.lastIndexOf("$");
        if(index != -1){
            String left = content.substring(0,index);
            String right = content.substring(index + 1);
            return 3 * count(left) + count(right) + 2;
        }
        return Integer.parseInt(content);
    }
}
