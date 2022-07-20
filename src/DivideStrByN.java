import java.util.*;

/*
2022.7.16

按要求分解字符串，输入两个数M，N，M代表输入的M个待处理的字符串，N代表输出的每串字符串要处理成的位数，不够补0。

例如：

输入：2  8

          abc  123456789

输出：abc00000

          12345678,90000000


————————————————
版权声明：本文为CSDN博主「wdkirchhoff」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wdkirchhoff/article/details/42366287
 */
public class DivideStrByN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] arr = sc.nextLine().split(" ");
            int num = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            String[] strs = sc.nextLine().split(" ");
            List<String> res = new ArrayList<>();
            int count = 0;//记有多少个逗号
            for(String s : strs){
                StringBuilder sb = new StringBuilder();
                if(s.length() < n){
                    int c = n - s.length();
                    sb.append(s);
                    for(int i = 0;i < c;i++){
                        sb.append("0");
                    }
                    res.add(sb.toString());
                }else if(s.length() > n){
                    char[] chars = s.toCharArray();
                    int c = s.length() - n;
                    for(int i = 1;i <= chars.length;i++){
                        if(i % n == 0 ){
                            sb.append(chars[i - 1]);
                            sb.append(",");
                            count++;
                        }else {
                            sb.append(chars[i - 1]);
                        }
                    }
                    int size = sb.length();
                    while(size < (count + 1) * n + count){
                        sb.append("0");
                        size++;
                    }
                    res.add(sb.toString());
                }else {
                    sb.append(s);
                    res.add(sb.toString());
                }
            }
            for(String s : res){
                System.out.println(s);
            }
        }
    }
}
