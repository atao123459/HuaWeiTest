import java.util.*;

/*
2022.8.3

一群大雁往南飞，给定一个字符串记录地面上的游客听到的大雁叫声，请给出叫声最少由几只大雁发出。

具体的:

1.大雁发出的完整叫声为”quack“，因为有多只大雁同一时间嘎嘎作响，所以字符串中可能会混合多个”quack”。

2.大雁会依次完整发出”quack”，即字符串中’q’ ,‘u’, ‘a’, ‘c’, ‘k’ 这5个字母按顺序完整存在才能计数为一只大雁。如果不完整或者没有按顺序则不予计数。

3.如果字符串不是由’q’, ‘u’, ‘a’, ‘c’, ‘k’ 字符组合而成，或者没有找到一只大雁，请返回-1。

输入描述

一个字符串，包含大雁quack的叫声。1 <= 字符串长度 <= 1000，字符串中的字符只有’q’, ‘u’, ‘a’, ‘c’, ‘k’。

输出描述

大雁的数量

示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

quackquack

输出

1
 */
public class CountingGeese {
    static List<Character> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] chars = sc.nextLine().toCharArray();
            list = new ArrayList<>();
            for(char c : chars){
                list.add(c);
            }
            int sign = 0,res = 0,t = 0;
            while(!list.isEmpty()){
                res++;
                boolean flag = true;
                for(int i = 0;;){
                    if(flag){
                        if (list.get(0) != 'q'){
                            sign = 1;
                            break;
                        }
                        flag = false;
                    }
                    if(list.get(i) == 'q'){
                        t = find('u',i);
                    }else if(list.get(i) == 'u'){
                        t = find('a',i);
                    }else if(list.get(i) == 'a'){
                        t = find('c',i);
                    }else if(list.get(i) == 'c'){
                        t = find('k',i);
                    }else if(list.get(i) == 'k'){
                        t = find('q',i);
                        if(t == -1){
                            list.remove( i);
                            break;
                        }
                    }
                    list.remove( i);
                    if(t != -1){
                        t--;
                        i = t;
                    }else {
                        sign = 1;
                        break;
                    }
                }
                if(sign == 1){
                    break;
                }
            }
            if(sign == 1){
                System.out.println(-1);
            }else {
                System.out.println(res);
            }
        }
    }

    public static int find(char c,int i){
        for(i++;i < list.size();i++){
            if(list.get(i) == c){
                return i;
            }
        }
        return -1;
    }
}
