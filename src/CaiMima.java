import java.util.*;

/*
2022.8.5

小杨申请了一个保密柜，但是他忘记了密码。只记得密码都是数字，而且所有数字都是不重复的。

请你根据他记住的数字范围和密码的最小数字数量，帮他算下有哪些可能的组合，规则如下：
1、输出的组合都是从可选的数字范围中选取的，且不能重复；
2、输出的密码数字要按照从小到大的顺序排列，密码组合需要按照字母顺序，从小到大的顺序排序。
3、输出的每一个组合的数字的数量要大于等于密码最小数字数量；
4、如果可能的组合为空，则返回“None”

输入描述:

1、输入的第一行是可能的密码数字列表，数字间以半角逗号分隔
2、输入的第二行是密码最小数字数量

输出描述:

可能的密码组合，每种组合显示成一行，每个组合内部的数字以半角逗号分隔，从小到大的顺序排列。
输出的组合间需要按照字典序排序。
比如：
2,3,4放到2,4的前面

示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2,3,4
2

输出

2,3
2,3,4
2,4
3,4

说明

最小密码数量是两个，可能有三种组合：
2,3
2,4
3,4

三个密码有一种：
2,3,4
 */
public class CaiMima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            int length = sc.nextInt();
            List<List<String>> res = new ArrayList<>();
            LinkedList<String> list = new LinkedList<>();
            backTrack(str.length,res,list,0,str);
            List<List<String>> lists = res.stream().filter(list1 -> list1.size() >= length).sorted((o1,o2) -> {
                for(int i = 0;i < Math.min(o1.size(),o2.size());i++){
                    return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }).toList();

            String[] resStr = new String[lists.size()];
            if(lists.size() == 0){
                System.out.println("None");
            }else {
                for(int i = 0;i < lists.size();i++){
                    List<String> temp = lists.get(i);
                    StringBuilder sb = new StringBuilder();
                    for(String s: temp){
                        sb.append(s).append(",");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                    resStr[i] = sb.toString();
                }
            }
            for(String r : resStr){
                System.out.println(r);
            }
        }
    }

    public static void backTrack(int n,List<List<String>> res,LinkedList<String> list,int first,String[] chars){
        //由于需要不同长度的组合，所以进入递归直接加入res
        res.add(new ArrayList<>(list));
        for(int i = first;i < n;i++){
            list.addLast(chars[i]);
            backTrack(n,res,list,i + 1,chars);
            list.removeLast();
        }
    }
}
