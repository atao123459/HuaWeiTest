import java.util.*;

/*
2022.7.11
100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
输入描述:
输入一个整数参数M
输出描述:
如果输入参数M小于等于1或者大于等于100，输出“ERROR!”；否则按照原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
示例1：
输入
3
输出
58,91
说明
输入M为3，最后剩下两个人
示例2：
输入
4
输出
34,45,97
说明
输入M为4，最后剩下三个人
 */
public class CallNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= 1 || num >= 100) {
            System.out.println("ERROR!");
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            map.put(i, i);
        }
        int start = 1;
        while (num <= map.size()) {
            //Iterator是迭代器，用于遍历map中的单个元素
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                int key = next.getKey();
                map.put(key, start++);//报数
                int value = next.getValue();
                if (value == num) {//喊到num的元素删除，下一位开始从一报数
                    iterator.remove();
                    start = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb);
    }
}
