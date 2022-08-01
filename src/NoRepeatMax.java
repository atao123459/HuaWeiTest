import java.util.*;

/*
2022.8.1

 * 给定一个正整数，给出消除重复数字以后最大的整数
 * 输入描述:
 * 正整数，注意考虑长整数
 * 输出描述:
 * 消除重复数字以后的最大整数
 * 示例1
 * 输入
 * 423234
 * 输出
 * 432
 */
public class NoRepeatMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            Set<Integer> set = new HashSet<>();
            for(char c : str.toCharArray()){
                set.add(Integer.parseInt(String.valueOf(c)));
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2 - o1);
            for(int n : set){
                heap.offer(n);
            }
            StringBuilder res = new StringBuilder();
            while(heap.size() > 0){
                res.append(heap.poll());
            }
            System.out.println(res);
        }
    }
}
