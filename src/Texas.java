import java.util.*;

/*
2022.8.1

【德州扑克】

五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。

判断牌型:

牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
牌型6，三条：三张相同+两张单。

说明：

（1）五张牌里不会出现牌大小和花色完全相同的牌。
（2）编号小的牌型较大，如同花顺比四条大，依次类推。
（3）包含A的合法的顺子只有10 J Q K A和A 2 3 4 5;类似K A 2 3 4的序列不认为是顺子。

输入描述:

输入由5行组成，每行为一张牌大小和花色，牌大小为2~10、J、Q、K、A，花色分别用字符H、S、C、D表示红桃、黑桃、梅花、方块。

输出描述:

输出牌型序号，5张牌符合多种牌型时，取最大的牌型序号输出。

示例1  输入输出示例仅供调试，后台判题数据一般不包含示例

输入

4 H
5 S
6 C
7 D
8 D

输出

5

说明

4 5 6 7 8构成顺子，输出5

示例2   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

9 S
5 S
6 S
7 S
8 S

输出

1

说明

既是顺子又是同花，输出1，同花顺
 */
public class Texas {
    static List<String> test = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            list.add(str);
            if (list.size() == 5) {
                int type = getCardType(list);
                System.out.println(type);
            }
            System.out.println(test);
        }
    }

    public static int getCardType(List<String> list) {
        List<String> numList = new ArrayList<>();
        Set<String> numSet = new HashSet<>();//数字set判断是否有多个不同的数字
        Set<String> colorSet = new HashSet<>();//颜色set判断是否有多个不同的颜色
        //数字和颜色存入集合中
        for (String s : list) {
            String num = s.split(" ")[0];
            String color = s.split(" ")[1];
            switch (num) {
                case "J" -> {
                    numList.add("11");
                    numSet.add("11");
                }
                case "Q" -> {
                    numList.add("12");
                    numSet.add("12");
                }
                case "K" -> {
                    numList.add("13");
                    numSet.add("13");
                }
                case "A" -> {
                    numList.add("14");
                    numSet.add("14");
                }
                default -> {
                    numList.add(num);
                    numSet.add(num);
                }
            }
            colorSet.add(color);
        }
        int type = 7;
        //set里只有一种颜色，只会是同化或者同花顺
        if (colorSet.size() == 1) {
            Collections.sort(numList);
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {
                    if (i == numList.size() - 2) {
                        type = 1;
                    }
                    continue;
                } else {
                    if (type > 4)
                        type = 4;
                }
            }
        }
        //set中有两种数字，只会是葫芦或者四条
        if (numSet.size() == 2) {
            Collections.sort(numList);
            //排序后，四条的情况只会出现在头尾两张
            if (!numList.get(0).equals(numList.get(1)) || !numList.get(numList.size() - 1).equals(numList.get(numList.size() - 2))) {
                if (type > 2) {
                    type = 2;
                }
            } else {
                if (type > 3) {
                    type = 3;
                }
            }
        }
        //set中有三个数，一定是三张
        if (numSet.size() == 3) {
            if (type > 6) {
                type = 6;
            }
        }
        //set中有两种颜色，可能是顺子
        if (colorSet.size() > 1) {
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {
                    if (i == numList.size() - 2) {
                        type = 5;
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return type;
    }
}