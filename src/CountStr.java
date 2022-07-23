import java.util.*;

/*
2022.7.15

字符串统计（全量和占用字符集）
题目描述：
给定两个字符集合， 一个是全量字符集， 一个是已占用字符集， 已占用字符集中的字符不能再使用， 要求输出剩余可用字符集。

输入描述:
输入一个字符串 一定包含@，@前为全量字符集 @后的为已占用字符集
已占用字符集中的字符，一定是全量字符集中的字符，字符集中的字符跟字符之间使用英文逗号隔开
每个字符都表示为字符+数字的形式，用英文冒号分隔，比如a:1标识一个a字符
字符只考虑英文字母，区分大小写，数字只考虑正整型 不超过100
如果一个字符都没被占用，@标识仍存在
输出描述:
输出可用字符集，
不同的输出字符集之间用回车换行，
注意：输出的字符顺序要跟输入的一致，不能输出b:3,a:2,c:2
如果某个字符已全部占用，则不需要再输出
示例 1：

输入
a:3,b:5,c:2@a:1,b:2
1
输出
a:2,b:3,c:2
1
说明：
全量字符集为三个a，5个b，2个c
已占用字符集为1个a，2个b
由于已占用字符不能再使用
因此剩余可用字符为2个a，3个b，2个c
示例 2：

输入
a:3,b:5,c:2@
1
输出
a:3,b:5,c:2@

————————————————
版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44052055/article/details/123926523
 */
public class CountStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] strs = s.split("@");
            if(s.indexOf("@") == s.length() - 1){
                System.out.println(s);
                return;
            }
            String[] strAll = strs[0].split(",");
            String[] used = strs[1].split(",");
            Map<String,Integer> map = new HashMap<>();
            for (String s1 : strAll) {
                String[] item = s1.split(":");
                String str = item[0];
                int num = Integer.parseInt(item[1]);
                map.put(str, num);
            }
            for(String s1 : used){
                String[] item = s1.split(":");
                String str = item[0];
                int num = Integer.parseInt(item[1]);
                if(map.containsKey(str))
                    map.put(str,map.get(str) - num);
            }
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                String key = entry.getKey();
                int value = entry.getValue();
                if(value == 0){
                    continue;
                }
                sb.append(key).append(":").append(value);
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb);
        }
    }
}
