import java.util.*;

/*
2022.7.19

考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，请你写个程序来把之前石碑上文字可能的组合全部写出来，排序按大小升序

输入
3
a b c
输出
abc
acb
bac
bca
cab
cba

输入
3
a b a
输出
aab
aba
baa

思路
一开始想先生成下标序列再转换为字符串，后面觉得吧，还不如我直接动态递归生成这些，我用StringBuilder即可，反正字符串必定是要生成的。
我把那些碎片当做一个字符串集合，每次取一块（排列组合），然后递归继续取，最后取完了就把最后的字符串丢到Set集合中去重。最后排个序输出。
其中一定要注意List、StringBuilder这种对象进行递归调用传递参数的时候传递的是引用类型，所以每次操作完下去递归的时候都是需要复制一份的，不要直接传递会改的同一份的。
————————————————
版权声明：本文为CSDN博主「HumoChen99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/HumorChen99/article/details/120329819
 */
public class Archeology {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n  = Integer.parseInt(sc.nextLine());
//            sc.nextLine();
            String str = sc.nextLine();
//            List<String> items = new ArrayList<>(Arrays.asList(str));
//            Set<String> set = new HashSet<>();
//            combine(items, new StringBuilder(), set);
//            Iterator<String> iterator = set.iterator();
//            List<String> res = new ArrayList<>();
//            while(iterator.hasNext()){
//                res.add(iterator.next());
//            }
//            res.sort((o1,o2) -> o1.compareTo(o2));
//            for(String s : res){
//                System.out.println(s);
//            }

            //方法2 排列组合加回溯
            String s = str.replace(" ", "");
            char[] chars = s.toCharArray();
            List<String> res = new ArrayList<>();
            backTrack(chars.length,res,chars,0);
            System.out.println(res);
        }
    }

    public static void backTrack(int n,List<String> res,char[] chars,int first){
        if(first == n){
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = first;i < n;i++){
            if(set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars,first,i);
            backTrack(n,res,chars,first + 1);
            swap(chars,first,i);
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void combine(List<String> str, StringBuilder sb, Set<String> set) {
        if (str.size() != 0) {
            int length = str.size();
            for (int i = 0; i < length; i++) {
                StringBuilder builder = new StringBuilder(sb);
                builder.append(str.get(i));
                List<String> list = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    list.add(j, str.get(j));//将str.get(j)存到list中的j位置上
                }
                list.remove(i);
                combine(list, builder, set);//使用递归对字母进行排列组合
            }
        } else {
            if (sb.length() > 0) {
                set.add(sb.toString());
            }
        }
    }
}
