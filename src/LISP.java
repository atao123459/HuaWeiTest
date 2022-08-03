import java.util.*;

/*
2022.8.3

LISP 语言唯一的语法就是括号要配对。

形如 (OP P1 P2 …)，括号内元素由单个空格分割。

其中第一个元素 OP 为操作符，后续元素均为其参数，参数个数取决于操作符类型。

注意：

参数 P1, P2 也有可能是另外一个嵌套的 (OP P1 P2 …) ，

当前 OP 类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法，

简单起见，所有 OP 参数个数均为 2 。

举例:

输入：(mul 3 -7)

输出：21

输入：(add 1 2)

输出：3

输入：(sub (mul 2 4) (div 9 3))

输出：5

输入：(div 1 0)

输出：error

题目涉及数字均为整数，可能为负；

不考虑 32 位溢出翻转，计算过程中也不会发生 32 位溢出翻转，

除零错误时，输出 “error”，

除法遇除不尽，向下取整，即 3/2 = 1

思路：化繁为简，从单个(add 1 2)入手，遇到左括号进栈，遇到右括号出栈计算，计算结果再存入栈中
 */
public class LISP {
    static boolean isError;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine().replaceAll("\\(","( ").replaceAll("\\)"," )");
            //patten用于存括号,opera用于存操作符和数字
            Deque<String> patten = new LinkedList<>();
            Deque<String> opera = new LinkedList<>();
            String[] s = str.split(" ");

            int p1,p2;
            String operation;
            isError = false;
            int res = 0;
            for(String item : s){
                if(item.equals("(")){
                    patten.push(item);
                }else if(item.equals(")")){//化繁为简，从单个(add 1 2)入手
                    if(patten.isEmpty()){
                        isError = true;
                    }
                    p2 = Integer.parseInt(opera.pop());
                    p1 = Integer.parseInt(opera.pop());
                    operation = opera.pop();
                    res = calculate(operation,p1,p2);
                    opera.push(String.valueOf(res));//计算结果存入栈中
                }else {
                    opera.push(item);
                }
                if(isError)
                    break;
            }
            if(isError){
                System.out.println("error");
            }else {
                System.out.println(res);
            }
        }
    }

    public static int calculate(String operation,int p1,int p2){
        int res = 0;
        switch (operation) {
            case "add":
                res = p1 + p2;
                break;
            case "sub":
                res = p1 - p2;
                break;
            case "mul":
                res = p1 * p2;
                break;
            case "div":
                if (p2 == 0) {
                    isError = true;
                } else {
                    res = p1 / p2;
                }
                break;
        }
        return res;
    }
}
