import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
.输入一些单词 再输入一个前缀 输出所有前缀开始的单词 不包括相同的单词 按字典序排序

input:
asd as as,asD     // 单词
a                 // 前缀

output:
as asD asd
注：任何标点符号视为分界 即don't 视为单词 don 和 t
 */
public class SamePreFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            List<String> list = new ArrayList<>();
            String str = sc.nextLine();
            String[] words = str.split(" ");
            char prefix = sc.nextLine().charAt(0);
            for (String s : words) {
                if (s.contains("'")) {
                    String[] spilt = s.split("'");
                    for (int i = 0; i < spilt.length; i++) {
                        if (spilt[i].startsWith(String.valueOf(prefix)) && !list.contains(spilt[i])) {
                            list.add(spilt[i]);
                        }
                    }
                } else {
                    if (s.startsWith(String.valueOf(prefix)) && !list.contains(s)) {
                        list.add(s);
                    }
                }
            }
//        list.sort(String::compareTo);
            Collections.sort(list);
            for (int i = 0;i < list.size();i++) {
                if(i == list.size() - 1){
                    System.out.println(list.get(i));
                }else {
                    System.out.print(list.get(i) + " ");
                }
            }
        }
    }
}
