import java.util.*;

/*
2022.7.16

给出几组[字符串]的数字，需要获得组成的最大数字。
 */
public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] arr = sc.nextLine().split(" ");
            PriorityQueue<String> heap = new PriorityQueue<>((o1,o2) -> (o2 + o1).compareTo(o1 + o2));
            for(String s : arr){
                heap.offer(s);
            }
            StringBuilder res = new StringBuilder();
            while(heap.size() > 0){
                res.append(heap.poll());
            }
            System.out.println(res);
        }
    }
}
