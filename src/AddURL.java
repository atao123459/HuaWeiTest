import java.util.*;

/*
2022.7.13

给定一个URL前缀和URL后缀，通过","分割，需要将其连接为一个完整的URL，如果前缀结尾和后缀开头都没有“/”，需自动补上“/”连接符，如果前缀结尾和后缀开头都为“/”，需自动去重。
约束：不用考虑前后缀URL不合法情况。
输入描述:
URL前缀（一个长度小于100的字符串),URL后缀（一个长度小于100的字符串）。
输出描述:
拼接后的URL。
示例1
输入
/acm,/bb
输出
/acm/bb
示例2
输入
/abc/,/bcd
输出
/abc/bcd
示例3
输入
/acd,bef
输出
/acd/bef
示例4
输入
,
输出
/
————————————————
版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class AddURL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() == 1){
            System.out.println("/");
            return;
        }
        String[] str = s.split(",");
        String url1 = str[0];
        String url2 = str[1];
        if (url1 == null && url2 == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        char[] charUrl1 = url1.toCharArray();
        char[] charUrl2 = url2.toCharArray();
        for(int i = 0;i < charUrl1.length;i++){
            char c = charUrl1[i];
            if(c == '/' && i != 0){
                continue;
            }else {
                sb.append(c);
            }
        }
        sb.append('/');
        for(int i = 0;i < charUrl2.length;i++){
            char c = charUrl2[i];
            if(c == '/' ){
                continue;
            }else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
